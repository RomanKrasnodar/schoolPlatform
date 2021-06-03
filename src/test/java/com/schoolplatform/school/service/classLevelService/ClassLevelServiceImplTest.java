package com.schoolplatform.school.service.classLevelService;

import com.schoolplatform.school.dao.ClassLevelRepository;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
class ClassLevelServiceImplTest {

    @Mock
    ClassLevelRepository classLevelRepository;

    ClassLevelServiceImpl classLevelService;

//    @Before
//    public void setUp() throws Exception {
//        classLevelService = new ClassLevelServiceImpl(classLevelService);
//    }
//
//    @Test
//    public void getClassLevelToStudent_levelExists() {
//        //given
//        Student student = new Student();
//        student.setBirthDate(LocalDate.of(2015, 11, 5));
//        Parallel expectedClassLevel = new Parallel();
//        expectedClassLevel.setClassLevel(0);
//        when(classLevelRepository.findByClassLevel(0)).thenReturn(expectedClassLevel);
//        //when
//        Parallel result = classLevelService.getClassLevelToStudent(student);
//        //then
//        assertEquals(expectedClassLevel, result);
//    }
//
//    @Test
//    public void getClassLevelToStudent_levelDoesNotExist() {
//        //given
//        Student student = new Student();
//        student.setBirthDate(LocalDate.of(2015, 11, 5));
//        Parallel expectedClassLevel = new Parallel();
//        expectedClassLevel.setClassLevel(0);
//        when(classLevelRepository.findByClassLevel(0)).thenReturn(null);
//        when(classLevelRepository.save(expectedClassLevel)).thenReturn(expectedClassLevel);
//        //when
//        Parallel result = classLevelService.getClassLevelToStudent(student);
//        //then
//        assertEquals(expectedClassLevel, result);
//        verify(classLevelRepository).save(expectedClassLevel);
//    }
}