package devsepark.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import devsepark.board.common.MediaUtil;
import devsepark.board.model.BoardFile;
import devsepark.board.service.BoardFileService;

@Controller
public class BoardFileController {
	@Autowired
	private BoardFileService boardFileService;

	//	@RequestMapping(value = "")
	//    public String listUploadedFiles(Model model) throws IOException {
	//        
	//        model.addAttribute("files", imageService.loadAll().collect(Collectors.toList()));
	//        
	//        return "index";
	//    }

	@RequestMapping(value = "/image/{imageId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> replyFile(@PathVariable("imageId") String imageId){
		try {
			System.out.println(imageId);
			BoardFile boardFile = boardFileService.selectBoardFileOne(imageId);
			HttpHeaders header = new HttpHeaders();
			System.out.println(boardFile.toString());
			String fileName = boardFile.getName();
			header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");
			if (MediaUtil.containsImageMediaType(boardFile.getType())) {
				header.setContentType(MediaType.valueOf(boardFile.getType()));
			} else {
				header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			}
			System.out.println("download image");
			Resource resource = boardFileService.loadAsResource(boardFile.getStorageName());
			return ResponseEntity.ok().headers(header).body(resource);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(value = "/image", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file){
		try {
			System.out.println("upload process");
			BoardFile uploadedFile = boardFileService.store(file);
			
			return ResponseEntity.ok().body("/image/" + uploadedFile.getId());
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

}
