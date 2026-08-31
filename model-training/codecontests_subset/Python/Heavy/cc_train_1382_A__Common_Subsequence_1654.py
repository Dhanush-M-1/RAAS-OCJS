import sys
import os,io

# input = sys.stdin.readline
# input_all = sys.stdin.read
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
input_all = io.BytesIO(os.read(0,os.fstat(0).st_size)).read
def read_int():
	return map(int, input().split())
def read_list():
	return list(map(int, input().split()))
def print_list(l):
	print(' '.join(map(str,l)))
# import heapq as hq
# import bisect as bs
# from collections import deque as dq
# from collections import defaultdict as dc 
# import math

# f = open('test.py')
# input = f.readline
# input_all = f.read
# def solve(a):


N = int(input())
for i in range(N):
	l1,l2 = read_int()
	a = set(read_list())
	b = set(read_list())
	tmp = a&b 
	if not tmp:
		print('NO')
	else:
		print('YES')
		print('1 %d'%tmp.pop())