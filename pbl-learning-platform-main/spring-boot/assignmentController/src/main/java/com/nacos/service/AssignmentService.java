package com.nacos.service;


import com.nacos.core.Service;
import com.nacos.entity.Assignment;
import com.nacos.entity.DoneInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by Chongli on 2020/05/14.
 */
@FeignClient(name = "assignment-service",path = "/assignment")
public interface AssignmentService  {

    /**
     * 创建一个项目
     * @param assignment
     */
    @RequestMapping("/createAssignment")
    int createAssignment(@RequestParam("assignment") Assignment assignment);

    /**
     * 创建多个项目
     * @param assignments
     * @return
     */
    @RequestMapping("/createAssignments")
    List<Integer> createAssignments(@RequestParam("assignments") List<Assignment> assignments);

    /**
     * 修改任务状态
     * @param assignment
     */
    @RequestMapping("/changeAssignment")
    void changeAssignment(@RequestParam("assignment") Assignment assignment);

    /**
     * 一次修改多个任务
     * @param assignments
     */
    @RequestMapping("/changeAssignments")
    void changeAssignments(@RequestParam("assignments") List<Assignment> assignments);

    /**
     * 删除任务
     * @param p_id
     * @param a_id
     */
    @RequestMapping("/deleteAssignment")
    void deleteAssignment(@RequestParam("p_id") String p_id,@RequestParam("a_id") String a_id);

    /**
     * 一次删除多个任务
     * @param p_id
     * @param a_idList
     */
    @RequestMapping("/deleteAssignments")
    void deleteAssignments(@RequestParam("p_id") String p_id,@RequestParam("a_idList") List<Integer> a_idList);

    /**
     * 催促未完成的同学完成任务
     * @param p_id
     * @param a_id
     */
    @RequestMapping("/urgeAssignment")
    void urgeAssignment(@RequestParam("p_id") String p_id,@RequestParam("a_id") String a_id);

    /**
     * 同学回应urge
     * @param p_id
     * @param a_id
     */
    @RequestMapping("/applyUrge")
    void applyUrge(@RequestParam("p_id") String p_id,@RequestParam("a_id") String a_id,@RequestParam("s_id") String s_id);

    /**
     * 搜索项目中所有的任务(按a_id排序)
     * @param p_id
     * @return
     */
    @RequestMapping("/searchAssignment")
    List<Assignment> searchAssignment(@RequestParam("p_id") String p_id);

    /**
     * 获得该项目下任务总数
     * @param p_id
     * @return
     */
    @RequestMapping("/countAssignment")
    int countAssignment(@RequestParam("p_id") String p_id);

    /**
     * 搜索项目中任务的完成情况(按s_id排序)
     * @param p_id
     * @return
     */
    @RequestMapping("/countAssignmentDone")
    List<DoneInformation> countAssignmentDone(@RequestParam("p_id") String p_id);

    /**
     * 搜索该生在每个项目中被urge的情况(按s_id排序)
     * @param p_id
     * @param s_id
     * @return
     */
    @RequestMapping("/searchAssignmentUrge")
    Object searchAssignmentUrge(@RequestParam("p_id") String p_id,@RequestParam("s_id") String s_id);

    /**
     * 搜索学生完成所有任务的状态(按a_id排序)
     * @param p_id
     * @param s_id
     * @return
     */
    @RequestMapping("/searchDoneStatus")
    Object searchDoneStatus(@RequestParam("p_id") String p_id,@RequestParam("s_id") String s_id);

    /**
     * 搜索学生完成该任务的状态
     * @param p_id
     * @param s_id
     * @return
     */
    @RequestMapping("/searchStudentDone")
    boolean searchStudentDone(@RequestParam("p_id") String p_id,@RequestParam("s_id") String s_id,@RequestParam("a_id") String a_id);

    /**
     * 修改学生完成该任务的状态
     * @param p_id
     * @param s_id
     * @return
     */
    @RequestMapping("/updateStudentDone")
    void updateStudentDone(@RequestParam("p_id") String p_id,@RequestParam("s_id") String s_id,@RequestParam("a_id") String a_id,@RequestParam("doneOrNot") boolean doneOrNot);

    /**
     * 获得完成该任务的学生个数
     * @param p_id
     * @param a_id
     * @return
     */
    @RequestMapping("/searchAssignmentDoneNum")
    int searchAssignmentDoneNum(@RequestParam("p_id") String p_id,@RequestParam("a_id") String a_id);

    /**
     * 搜索项目里所有任务完成的人数(以a_id排序)
     * @param p_id
     * @return
     */
    @RequestMapping("/searchAllAssignmentsDoneNum")
    List<Integer> searchAllAssignmentsDoneNum(@RequestParam("p_id") String p_id);

    /**
     * 搜索项目中指定学生的任务的完成情况
     * @param p_id
     * @param u_id
     * @return
     */
    @RequestMapping("/countAssignmentDoneByUidAndPid")
     int countAssignmentDoneByUidAndPid(@RequestParam("p_id") String p_id,@RequestParam("u_id") String u_id);

    /**
     * 标记完成任务
     * @param a_id
     * @param p_id
     * @param u_id
     */
    @RequestMapping("/doneAssignment")
     void doneAssignment(@RequestParam("a_id") String a_id,@RequestParam("p_id") String p_id,@RequestParam("u_id") String u_id);
}
