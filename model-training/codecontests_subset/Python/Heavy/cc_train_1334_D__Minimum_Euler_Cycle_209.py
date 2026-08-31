import sys
input = sys.stdin.readline
from collections import *

def binary_search1():
    l, r = 1, n-1
    
    while l<=r:
        m = (l+r)//2
        
        if acc[m]-acc[1]+1<=left:
            l = m+1
        else:
            r = m-1
    
    return r
    
def binary_search2():
    l, r = 1, n-1
    
    while l<=r:
        m = (l+r)//2
        
        if acc[m+1]-acc[1]>=right:
            r = m-1
        else:
            l = m+1
    
    return l

T = int(input())

for _ in range(T):
    n, left, right = map(int, input().split())
    l = [0, 2*n-2]
    
    for _ in range(n-2):
        l.append(l[-1]-2)
    
    l[-1] += 1
    #print(l)
    acc = [0]
    
    for li in l:
        acc.append(acc[-1]+li)
    
    left_n = binary_search1()
    right_n = binary_search2()
    #print(left_n)
    #print(right_n)
    ans = []
    
    for i in range(left_n, right_n+1):
        li = []
        
        for j in range(l[i]-1):
            if j%2==0:
                li.append(i)
            else:
                if j==1:
                    li.append(i+1)
                else:
                    li.append(li[-2]+1)
        
        if i==n-1:
            li.append(1)
        else:
            li.append(n)
            
        ans += li
    #print(ans)
    sta = left-(acc[left_n]-acc[1])-1
    #print(sta)
    print(*ans[sta:sta+right-left+1])