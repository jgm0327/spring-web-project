package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr = {25L, 26L, 27L, 28L, 29L};

	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper mapper;
	
	@Test
	public void testCount() {
		int count = mapper.getCountByBno(28L);
		log.info(count);
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(1, 10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 28L);
		replies.forEach(e -> log.info(e));
	}
	
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		replies.forEach(reply -> log.info(reply));
	}
	
	
	
	/*
	 * @Test public void deleteMapper() { Long targetRno = 1L;
	 * 
	 * mapper.delete(targetRno); }
	 * 
	 * @Test public void readMapper() { Long targetRno = 5L;
	 * 
	 * ReplyVO vo = mapper.read(targetRno);
	 * 
	 * log.info(vo); }
	 * 
	 * @Test public void updateMapper() { Long targetRno = 10L; ReplyVO vo =
	 * mapper.read(targetRno);
	 * 
	 * vo.setReply("Update Reply ");
	 * 
	 * int count = mapper.update(vo);
	 * 
	 * log.info("UPDATE COUNT: " + count); }
	 * 
	 * 
	 * @Test public void testMapper() { log.info(mapper); }
	 */
	
	
	
}
