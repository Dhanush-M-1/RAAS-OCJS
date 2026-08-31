from collections import deque
from math import *
import heapq
from random import *
import sys
from copy import deepcopy

t=int(input())
for i in range(t):
	n=int(input())
	l=list(map(int,input().split()))

	a=l[0]
	b=l[1]
	c=l[-1]

	if a==0 and b==0 and c==0:
		print(1,2,n)
	else:
		if a+b>c:
			print(-1)

		else:
			print(1,2,n)

			