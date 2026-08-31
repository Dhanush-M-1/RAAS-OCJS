# f = open('test.py')
# def input():
# 	return f.readline().replace('\n','')
 
# import heapq
# from collections import defaultdict
def read_list():
	return list(map(int,input().strip().split(' ')))
def print_list(l):
	print(' '.join(map(str,l)))
 
def judge_3(n):
	tmp = 0
	for c in str(n):
		tmp+=int(c)
	return tmp%3==0
 
N = int(input())
for _ in range(N):
	n = int(input())
	two,three = 0,0
	while n&1==0:
		two+=1
		n>>=1
	while judge_3(n):
		three+=1
		n//=3
	if n!=1 or two>three:
		print(-1)
	else:
		print(three-two+three)