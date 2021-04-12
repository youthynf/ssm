package com.study.dao;

import com.study.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    public Emp findEmpByEmpno(Integer empno);

    public int updateEmp(Emp emp);

    public int deleteEmp(Integer empno);

    public int insertEmp(Emp emp);

    Emp selectEmpByNoAndName(@Param("empno") Integer empno, @Param("ename") String ename, @Param("t") String tablename);

    Emp selectEmpByNoAndName2(Map<String, Object> map);

    List<Emp> selectAllEmp();

    Map<String, Object> selectEmpByEmpReturnMap(Integer empno);

    @MapKey("empno")
    Map<Integer, Emp> getAllEmpReturnMap();

    Emp selectEmpAndDept(Integer empno);

    Emp selectEmpAndDeptBySimple(Integer empno);

    List<Emp> selectEmpByStep(Integer deptno);

    public List<Emp> getEmpByCondition(Emp emp);

    public List<Emp> getEmpByConditionChoose(Emp emp);

    public List<Emp> getEmpByDeptnos(@Param("deptnos") List<Integer> deptnos);

    public int updateEmpByEmpno(Emp emp);

}