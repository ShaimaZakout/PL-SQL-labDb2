# PL-SQL-labDb2
Write a PHP or Java code to call the stored procedure and function you defined in the previous assignment.

The stored procedure is ==>

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_salary`(in jobTitle varchar(45), in incrAmount int )
BEGIN
declare minS , maxS float default 0;
set minS=(select min_salary   from  jobs_data where job_title = jobTitle)+incrAmount  ; 
set maxS = (select  max_salary  from  jobs_data where job_title = jobTitle)+incrAmount  ; 
 update  jobs_data  SET  min_salary = minS ,max_salary = maxS where job_title = jobTitle;
END

The function is ==>

CREATE DEFINER=`root`@`localhost` FUNCTION `get_high_salary_job`() RETURNS varchar(45) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
declare maxSalary varchar(45) ;
declare maxSa double default 0.0 ;
select max(max_salary) into maxSa from jobs_data;
select job_title  into maxSalary from jobs_data  where max_salary = maxSa;
RETURN maxSalary;
END
