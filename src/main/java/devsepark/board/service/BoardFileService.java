package devsepark.board.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import devsepark.board.common.UploadFileUtil;
import devsepark.board.model.BoardFile;

@Service
public class BoardFileService {
	private final Path rootLocation = Paths.get("d:/test");

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	//파일 저장 및 insert
	public BoardFile store(MultipartFile file) throws Exception {
		try {
			if (file.isEmpty()) {
				throw new Exception("Failed to store empty file " + file.getOriginalFilename());
			}

			String saveFileName = UploadFileUtil.fileSave(rootLocation.toString(), file);

			if (saveFileName.toCharArray()[0] == '/') {
				saveFileName = saveFileName.substring(1);
			}

			Resource resource = loadAsResource(saveFileName);

			BoardFile boardFile = new BoardFile();
			boardFile.setStorageName(saveFileName);
			boardFile.setName(file.getOriginalFilename());
			boardFile.setType(file.getContentType());
			boardFile.setPath(rootLocation.toString().replace(File.separatorChar, '/') + File.separator + saveFileName);
			boardFile.setSize(Long.toString(resource.contentLength()));
			
			sqlSession.insert("insertBoardFile", boardFile);
			boardFile.setId((String) sqlSession.selectOne("selectBoardFileId", boardFile.getStorageName()));
			return boardFile;
		} catch (IOException e) {
			throw new Exception("Failed to store file " + file.getOriginalFilename(), e);
		}
	}
	
	public BoardFile selectBoardFileOne(String fileName) {
		System.out.println(fileName);
		//return db select by id
		return sqlSession.selectOne("selectBoardFileOne", fileName);
	}

	public Resource loadAsResource(String fileName) throws Exception {
		try {
			if (fileName.toCharArray()[0] == '/') {
				fileName = fileName.substring(1);
			}

			Path file = loadPath(fileName);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new Exception("Could not read file: " + fileName);
			}
		} catch (Exception e) {
			throw new Exception("Could not read file: " + fileName);
		}
	}

	private Path loadPath(String fileName) {
		return rootLocation.resolve(fileName);
	}

	
}
