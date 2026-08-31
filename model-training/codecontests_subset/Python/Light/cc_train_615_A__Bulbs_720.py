import sys
input=sys.stdin.buffer.readline
import os
from math import*

n,m=map(int,input().split())
main_arr=[0]*m
while n:
	n-=1
	arr=list(map(int,input().split()))
	for i in range(1,arr[0]+1):
		if arr[i]!=0:
			main_arr[arr[i]-1]=1
#print(main_arr)
print("NO" if 0 in main_arr else "YES")