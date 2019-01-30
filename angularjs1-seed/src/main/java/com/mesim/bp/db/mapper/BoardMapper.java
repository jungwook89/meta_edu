package com.mesim.bp.db.mapper;

import com.mesim.bp.web.dto.BoardDetailData;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by MisunKim
 * Date: 2019-01-24 오후 2:10
 *
 * 게시판 관련 Mybatis Mapper Interface
 */
@Mapper
public interface BoardMapper {

    List<BoardDetailData> getBoardList(String user_id) throws SQLException;
    public void deletePost(Integer id) throws SQLException;
    public void deletePostDetail(Integer id) throws SQLException;
}
