from sys import stdin, stdout
from collections import defaultdict
import heapq
def get_int(): return int(stdin.readline().strip())
def get_ints(): return map(int,stdin.readline().strip().split()) 
def get_array(): return list(map(int,stdin.readline().strip().split()))
def get_string(): return stdin.readline().strip()
INF=1e10
for _ in range(int(stdin.readline())):
    n=get_int()
    px=0
    py=0
    flag=True
    for i in range(n):
        x,y=get_ints()
        if (x<px) or (y<py) or ((y-py)>(x-px)):
            flag=False
        px,py=x,y
    if flag:
        print("YES")
    else:
        print("NO")