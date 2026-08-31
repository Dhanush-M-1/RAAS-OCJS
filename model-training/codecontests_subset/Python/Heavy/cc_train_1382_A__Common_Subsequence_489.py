import sys
# sys.stdin = open('input.txt', 'r') 
# sys.stdout = open('output.txt', 'w')
import math
import collections
from sys import stdin,stdout,setrecursionlimit
import bisect as bs
setrecursionlimit(2**20)
M = 10**9+7

def countlen(s,val):
    cnt=0
    for i in range(len(s)-6):
        x = s[i:i+7]
        if(x==val):
            cnt+=1
    return cnt

def solve():
    n,m = list(map(int,stdin.readline().split()))
    a = list(map(int,stdin.readline().split()))
    b = list(map(int,stdin.readline().split()))
    d1={}
    d2={}
    for i in a:
        if(i not in d1):
            d1[i]=1
    for i in b:
        if i not in d2:
            d2[i]=1

    for i in a:
        if i in d2:
            print("YES")
            print("1 ",i)
            return
    for i in b:
        if i in d1:
            print("YES")
            print("1 ",i)
            return
    print("NO")



    


t = 1
t = int(stdin.readline())
if __name__ == "__main__":
    for _ in range(t):
        solve()
    
    
# n = int(stdin.readline())
# n,m = list(map(int,stdin.readline().split()))
# h = list(map(int,stdin.readline().split()))
# q = list(map(int,stdin.readline().split()))
# b = list(map(int,stdin.readline().split()))
# s = stdin.readline().strip('\n')
