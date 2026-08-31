import math
from sys import stdin
from collections import Counter,defaultdict,deque
mod=pow(10,9)+7
input=stdin.readline
def int1():
    return int(input())
def map1():
    return map(int,input().split())
def list1():
    return list(map(int,input().split()))
def solve():
    n,m=map1()
    l1=list1()
    l2=list1()
    l1=set(l1)
    l2=set(l2)
    l3=list(l1&l2)
    if(len(l3)!=0):
        print("YES")
        print(1,l3[0])
    else:
        print("NO")
    
for _ in range(int(input())):
    solve()