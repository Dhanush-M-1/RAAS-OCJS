import math as mt
import sys
from collections import *

inf = float('inf')
def ii(): return int(input())
def mii(): return map(int, input().split())
def lii(): return list(map(int, input().split()))
def gmat(n,m): return [[0]*m for _ in range(n)]
def imat(n): return [list(mii()) for _ in range(n)]

try:
	sys.stdin = open('data\\a.in', 'r') 
	input = sys.stdin.readline
except:pass

s = input()
l = [int(i) for i in s if i.isdigit()]
l.sort()
res = ''
for i in range(len(l)):
	if i!=len(l)-1:
		res+=str(l[i])+'+'
	else: res+=str(l[i])
print(res)