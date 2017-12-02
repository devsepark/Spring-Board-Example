package devsepark.board.common;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtil {
	
	//파일 저장
	public static String fileSave(String uploadPath, MultipartFile file) throws IllegalStateException, IOException {

		File uploadPathDir = new File(uploadPath);

		if ( !uploadPathDir.exists() ){
			uploadPathDir.mkdirs();
		}

		// 파일 중복명 처리
		String genId = UUID.randomUUID().toString();
		genId = genId.replace("-", "");

		String originalfileName = file.getOriginalFilename();
		String fileExtension = getExtension(originalfileName);
		String saveFileName = genId + "." + fileExtension;

		String savePath = makeCalendarPathDir(uploadPath);

		File target = new File(uploadPath + savePath, saveFileName);

		FileCopyUtils.copy(file.getBytes(), target);

		return makeFilePath(uploadPath, savePath, saveFileName);
	}

	//확장자 추출
	public static String getExtension(String fileName) {
		int dotPosition = fileName.lastIndexOf('.');
		
		if (-1 != dotPosition && fileName.length() - 1 > dotPosition) {
			return fileName.substring(dotPosition + 1);
		} else {
			return "";
		}
	}
	//현재 연월일별로 폴더를 생성요청.
	private static String makeCalendarPathDir(String uploadPath) {

		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		makeDir(uploadPath, yearPath, monthPath, datePath);


		return datePath;
	}
	//폴더 생성
	private static void makeDir(String uploadPath, String... paths) {

		System.out.println(paths[paths.length - 1] + " : " + new File(paths[paths.length - 1]).exists());
		//일일 폴더가 존재할 경우, 리턴
		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}
		//폴더 생성
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);

			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
	//파일 경로 생성
	private static String makeFilePath(String uploadPath, String path, String fileName) throws IOException {
		String filePath = uploadPath + path + File.separator + fileName;
		return filePath.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
}
