import sys, os.path
from collections import deque
from fractions import Fraction as f
def IO():
    if os.path.exists('input.txt'):
        sys.stdin = open('input.txt', 'r')
        sys.stdout = open('output.txt', 'w')
    else:
        input=sys.stdin.readline
        print=sys.stdout.write
def nextInt():
    return int(input())
def nextTuple():
    return [int(a) for a in input().split()]
def nextArray():
    return list(map(int, input().split()))
def nextLine():
    return input()
def nextStringArray():
    return list(input().split())
IO()
sb = ""

'''code starts here'''



t=nextInt()
for _ in range(t):
    n,m=nextTuple()
    a=nextArray()
    b=nextArray()
    dict={}
    for i in range(n):
        dict[a[i]]=1
    ans=0
    for i in range(m):
        if dict.get(b[i]) is not None:
            ans=b[i]
            break
    if ans==0:
        print("NO")
    else:
        print("YES")
        print(1,ans)
