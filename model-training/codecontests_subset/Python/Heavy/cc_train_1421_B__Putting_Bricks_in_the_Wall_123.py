import sys
from collections import defaultdict as dd
from collections import Counter as cc
from queue import Queue
import math
import itertools
try:
	sys.stdin = open('input.txt', 'r')
	sys.stdout = open('output.txt', 'w')
except:
	pass
# input = lambda: sys.stdin.buffer.readline().rstrip()



for _ in range(int(input())):
	q=int(input())
	a=[]
	for i in range(q):
		a.append(input())
	w=[]
	if a[0][1]=='1':
		if a[1][0]=='1':
			if a[q-1][q-2]=='1':
				w.append([q,q-1])
			if a[q-2][q-1]=='1':
				w.append([q-1,q])
		else:
			if a[q-1][q-2]=='1' and a[q-2][q-1]=='1':
				w.append([1,2])
			elif a[q-1][q-2]=='1':
				w.append([2,1])
				w.append([q,q-1])
			elif a[q-2][q-1]=='1':
				w.append([2,1])
				w.append([q-1,q])
			else:
				w.append([2,1])
	else:
		if a[1][0]=='1':
			if a[q-1][q-2]=='1' and a[q-2][q-1]=='1':
				w.append([2,1])
			elif a[q-1][q-2]=='1':
				w.append([1,2])
				w.append([q,q-1])
			elif a[q-2][q-1]=='1':
				w.append([1,2])
				w.append([q-1,q])
			else:
				w.append([1,2])
		else:
			if a[q-1][q-2]=='0':
				w.append([q,q-1])
			if a[q-2][q-1]=='0':
				w.append([q-1,q])
	print(len(w))
	for i in w:
		print(*i)