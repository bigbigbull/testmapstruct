package com.example.testmapstruct;


import com.example.testmapstruct.convert.EmployeeWorkConvert;
import com.example.testmapstruct.dto.EmployeeWorkDto;
import com.example.testmapstruct.po.EmployeeWorkPo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class TestMapStructApplicationTests {

    @Autowired
    private EmployeeWorkConvert employeeWorkConvert;

    @Test
    void test() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // 对象个数
        int n = 10;
        // 循环复制次数
        int m = 1;

        //  构建po对象
        List<EmployeeWorkPo> pos = createPos(n);
        // mapStruct
        testMapStruct(n, m, pos);

        // hutools的BenUtil
        testHutoolsBeanUtil(n, m, pos);

        // spring的BeanUtils
        testSpringBeanUtils(n, m, pos);

        // apache的BeanUtils
        testApacheBeanUtils(n, m, pos);

        // apache的PropertyUtils
        testApachePropertyUtils(n, m, pos);
    }

    private void testApachePropertyUtils(int n, int m, List<EmployeeWorkPo> pos) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            List<EmployeeWorkDto> dtos = new ArrayList<>(pos.size());
            for (EmployeeWorkPo po : pos) {
                EmployeeWorkDto dto = new EmployeeWorkDto();
                PropertyUtils.copyProperties(po, dto);
                dtos.add(dto);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("apache的PropertyUtils复制" + n + "个对象，" + m + "次所花时间为：" + (end - start) + "ms");
    }


    private void testApacheBeanUtils(int n, int m, List<EmployeeWorkPo> pos) throws InvocationTargetException, IllegalAccessException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            List<EmployeeWorkDto> dtos = new ArrayList<>(pos.size());
            for (EmployeeWorkPo po : pos) {
                EmployeeWorkDto dto = new EmployeeWorkDto();
                BeanUtils.copyProperties(po, dto);
                dtos.add(dto);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("apache的BeanUtils复制" + n + "个对象，" + m + "次所花时间为：" + (end - start) + "ms");
    }

    private void testSpringBeanUtils(int n, int m, List<EmployeeWorkPo> pos) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            List<EmployeeWorkDto> dtos = new ArrayList<>(pos.size());
            for (EmployeeWorkPo po : pos) {
                EmployeeWorkDto dto = new EmployeeWorkDto();
                org.springframework.beans.BeanUtils.copyProperties(po, dto);
                dtos.add(dto);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("spring的BeanUtils复制" + n + "个对象，" + m + "次所花时间为：" + (end - start) + "ms");
    }

    private void testHutoolsBeanUtil(int n, int m, List<EmployeeWorkPo> pos) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            List<EmployeeWorkDto> dtos = new ArrayList<>(pos.size());
            for (EmployeeWorkPo po : pos) {
                EmployeeWorkDto dto = new EmployeeWorkDto();
                cn.hutool.core.bean.BeanUtil.copyProperties(po, dto);
                dtos.add(dto);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("hutools的BeanUtil复制" + n + "个对象，" + m + "次所花时间为：" + (end - start) + "ms");
    }

    private void testMapStruct(int n, int m, List<EmployeeWorkPo> pos) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            employeeWorkConvert.po2Dtos(pos);
        }
        long end = System.currentTimeMillis();
        System.out.println("mapStruct复制" + n + "个对象，" + m + "次所花时间为：" + (end - start) + "ms");
    }


    /**
     * 创建n个po对象
     *
     * @param n 多少个
     * @return n个po对象
     */
    List<EmployeeWorkPo> createPos(int n) {
        List<EmployeeWorkPo> pos = new ArrayList<>(n);
        Date now = new Date();
        for (int i = 0; i < n; i++) {

            EmployeeWorkPo employeeWorkPo = EmployeeWorkPo.builder()
                    .id(String.valueOf(n)).updateAt(now)
                    .workTime(String.valueOf(n))
                    .attach(String.valueOf(n))
                    .endAt(now)
                    .beginAt(now)
                    .deptName("dsdasdasdadadadada")
                    .build();
            pos.add(employeeWorkPo);

        }
        return pos;
    }
}
