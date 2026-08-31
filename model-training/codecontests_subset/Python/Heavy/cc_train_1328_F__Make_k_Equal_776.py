import math,sys,bisect,heapq,os
from collections import defaultdict,Counter,deque
from itertools import groupby,accumulate
from functools import lru_cache
#sys.setrecursionlimit(200000000)
pr = lambda x:	x
def input(): return sys.stdin.readline().rstrip('\r\n')
#input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
aj = lambda: list(map(int, input().split()))
def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
#MOD = 1000000000 + 7
def Y(c):  print(["NO","YES"][c])
def y(c):  print(["no","yes"][c])
def Yy(c):  print(["No","Yes"][c])

def solve():
	n,k = aj()
	A = aj()
	G = defaultdict(list)
	C = Counter(A)
	xx = C.most_common(1)[0][1]
	if xx >= k:
		print(0)
		exit(0)
	P = list(set(A))
	for i in P:
		s = 0;p = i
		for j in range(C[p]):
			G[i].append(s)
		while i:
			i = i//2
			s+=1
			G[i]+=[s]*C[p]
	# pr(G)
	ans = 1e9
	for i in G.keys():
		if len(G[i]) >= k:
			r = sorted(G[i]);temp = 0
			for j in range(k):
				temp += r[j]
			#print(i,temp)
			ans = min(ans,temp)
			if ans == 0:
				break
	print(ans)




		

















try:
	#os.system("online_judge.py")
	sys.stdin = open('input.txt', 'r') 
	sys.stdout = open('output.txt', 'w')
	from aj import *
except:
	pass

solve()