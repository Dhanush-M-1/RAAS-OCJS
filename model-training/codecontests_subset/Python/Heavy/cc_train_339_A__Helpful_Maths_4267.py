import sys
import collections
import math
import functools
import itertools
import bisect
import operator
import heapq
import random
true=True
false=False
null=None
tcid=0
def ceil(a,b):
	ans=a//b
	if a%b!=0: ans+=1
	return ans
def perr(*args,**kwargs): print(*args,file=sys.stderr,**kwargs)
def line():
	ln=sys.stdin.readline().strip()
	#perr(ln)
	if ln=='': sys.exit()
	return ln
def lines(n): return [line() for i in range(n)]
def split(ln=None): return (ln or line()).split()
def parse(*parsers): return list(map((lambda p,w:p(w)),parsers,split()))
def nums(o=None):
	if o is not None:
		if isinstance(o, int): o=lines(o)
		elif isinstance(o, str): o=split(o)
	return list(map(int, o or split()))
def num(): return int(line())
#help("sys.modules")
"""
ceil(a,b)
perr(print) true false null tcid
num() nums(?) parse(..) split(?) lines(n) line()
"""
# 
# 
#
def solve(tcid=1):
	s=line()
	s=s[::2]
	s=list(s)
	s.sort()
	print(*s,sep="+")
#
while true:
	tcid+=1
	solve(tcid)
#
#
#
#
#
#