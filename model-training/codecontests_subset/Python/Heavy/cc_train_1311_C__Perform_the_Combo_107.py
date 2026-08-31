# coding: utf-8 
import math
import collections
import functools
import sys
import os


def solve():
	n,_ = map(int,input().split())
	s = input()
	table = list(map(int,input().split()))
	tt = {}
	table.append(n)
	for i in table:
		if(i in tt):
			tt[i]+= 1
		else:
			tt[i] = 1
	dp = [0] * 26
	res = [0] * 26
	for i in range(n):
		dp[ord(s[i])-ord('a')] += 1
		if((i+1) not in tt):
			continue
		for j in range(26):
			res[j]+=dp[j]*tt[i+1]
	for i in range(26):
		if(i):print(" ",end='')
		print(res[i],end='')
	print()
	return
	
def main():
	T = 1
	T = int(input())
	while (T):
		solve()
		T-=1

if __name__ == "__main__":
	main()
