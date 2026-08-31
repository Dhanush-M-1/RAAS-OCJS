import sys
import math
input=sys.stdin.readline

t=int(input())
for _ in range(t):
    n,m=map(int,input().split())
    s=input()
    p=list(map(int,input().split()))
    
    check=[0]*(n+1)
    for i in range(m):
        check[p[i]-1]+=1
    for i in range(n-2,-1,-1):
        check[i]=(check[i+1]+check[i])
    ll=[0]*26
    for i in range(n):
        ll[ord(s[i])-ord('a')]+=(check[i]+1)
    for i in range(len(ll)):
        print(ll[i],end=" ")
    print()
    
        
    
    
            

    
    
    
        