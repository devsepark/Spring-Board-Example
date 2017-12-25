package devsepark.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(BoardFileController.class);
	
	@Autowired
	private BoardFileService boardFileService;

	@RequestMapping(value = "/image/{imageId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> downloadImage(@PathVariable("imageId") String imageId){
		try {
			BoardFile boardFile = boardFileService.selectBoardFileOne(imageId);
			HttpHeaders header = new HttpHeaders();
			String fileName = boardFile.getName();
			header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");
			//이미지 타입 확인
			if (MediaUtil.containsImageMediaType(boardFile.getType())) {
				header.setContentType(MediaType.valueOf(boardFile.getType()));
			} else {
				//이미지 이외는 OCTET_STREAM(기타)
				//header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				//return error
			}
			
			Resource resource = boardFileService.loadAsResource(boardFile.getStorageName());
			
			logger.info("downloadImage, URL=/image/{},Method=GET",imageId);
			
			return ResponseEntity.ok().headers(header).body(resource);
		}catch(Exception e) {

			logger.error("Image Download error : id={}, msg={}", imageId, e.getMessage());
			
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(value = "/image", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file){
		try {
			
			BoardFile uploadedFile = boardFileService.store(file);
			
			logger.info("Upload Image, URL=/image/,Method=POST", uploadedFile.getName());
			
			return ResponseEntity.ok().body("/image/" + uploadedFile.getId());
		}catch (Exception e) {
			logger.error("Image Upload error : msg={}", e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}

}
