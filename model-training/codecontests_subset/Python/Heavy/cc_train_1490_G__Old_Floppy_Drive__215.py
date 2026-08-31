import math,sys,bisect,heapq,os
from collections import defaultdict,Counter,deque
from itertools import groupby,accumulate
from functools import lru_cache
#sys.setrecursionlimit(200000000)
int1 = lambda x: int(x) - 1
def input(): return sys.stdin.readline().rstrip('\r\n')
#input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
aj = lambda: list(map(int, input().split()))
def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
#MOD = 1000000000 + 7
def Y(c):  print(["NO","YES"][c])
def y(c):  print(["no","yes"][c])
def Yy(c):  print(["No","Yes"][c])

def solve():
	for _ in range(int(input())):
		n,m= aj()
		A = aj()
		x = aj()
		# print(A,x)
		A = [0] + list(accumulate(A))
		C = [0]
		for i in range(1,len(A)):
			C.append(max(C[-1],A[i]))
		# print(C)
		m = C[-1]
		s = A[-1]
		Ans = []
		if m == 0:
			Ans = [-1]*len(x)
		else:
			for i in x:
				if i > m and s <= 0:
					Ans.append(-1)
				else:
					a = 0
					if s > 0 and i > m:
						a += (i - m + s - 1)//s
					k = bisect.bisect_left(C,i - a*s)
					Ans.append(a*n + k - 1)
		print(*Ans)
			


try:
	#os.system("online_judge.py")
	sys.stdin = open('input.txt', 'r') 
	sys.stdout = open('output.txt', 'w')
except:
	pass

solve()

