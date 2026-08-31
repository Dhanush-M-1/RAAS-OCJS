#!/bin/python3

import math

a, b = [int(i) for i in input().split()]
hrs = 0
hrs += a
	
while a >= b:
	c = a//b
	r = a%b
	hrs += c
	a = (r+c)
	
print(hrs)