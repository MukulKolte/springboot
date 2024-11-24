package com.mycode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(public * com.mycode.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//create a pointcut on setter method
	@Pointcut("execution(public void set*(..))")
	public void setter() {};
	
	//create a pointcut on getter method
	@Pointcut("execution(public * get*())")
	public void getter() {};
	
	//create a pointcut to include package but exclude getters and setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {};
}
