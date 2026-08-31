import math,sys
from collections import Counter, defaultdict, deque
from sys import stdin, stdout
input = stdin.readline
li = lambda:list(map(int,input().split()))

def solve():
    n,m=li()
    s=input()
    a=li()
    c=Counter(a)
    j=0
    count=[0]*26
    ans=[0]*26
    for i in range(n):
        count[ord(s[i])-97]+=1
        ans[ord(s[i])-97]+=1
        if(i+1 in c):
            for j in range(26):
                ans[j]+=count[j]*c[i+1]
    print(*ans)

for _ in range(int(input())):
    solve()