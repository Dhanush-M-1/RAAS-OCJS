import math as mt
import bisect
import sys
#input=sys.stdin.readline
t=int(input())
import collections 
import heapq
#t=1
p=10**9+7
def ncr_util():
    inv[0]=inv[1]=1
    fact[0]=fact[1]=1
    for i in range(2,300001):
        inv[i]=(inv[i%p]*(p-p//i))%p
    for i in range(1,300001):
        inv[i]=(inv[i-1]*inv[i])%p
        fact[i]=(fact[i-1]*i)%p

    
def solve():
    l1=[]
    #print(l[0][1],l[1][0],l[-2][-1],l[-1][-2])
    if l[0][1]==l[1][0]:
        x=str(int(l[0][1])^1)
        #print(123,x)
        if l[-1][-2]!=x:
            l1.append([n,n-1])
        if l[-2][-1]!=x:
            l1.append([n-1,n])
        
    else:
        if l[n-1][n-2]==l[n-2][n-1]:
            x=str(int(l[n-1][n-2])^1)
            if l[0][1]!=x:
                l1.append([1,2])
            if l[1][0]!=x:
                l1.append([2,1])
        else:
            x='1'
            if l[0][1]!=x:
                l1.append([1,2])
            if l[1][0]!=x:
                l1.append([2,1])
            x='0'
            if l[-1][-2]!=x:
                l1.append([n,n-1])
            if l[-2][-1]!=x:
                l1.append([n-1,n])
    
    print(len(l1))
    if len(l1)>0:
        for i in range(len(l1)):
            print(l1[i][0],l1[i][1])        
        
            
        
        
for _ in range(t):
    n=int(input())
    l=[]
    for i in range(n):
        l.append(input())
    #s=input()
    #n=int(input())
    #n,x=(map(int,input().split()))
    #n1=n
    #a=int(input())
    #b=int(input())
    #n,x,k=map(int,input().split())
    #l=list(map(int,input().split()))
    #a,b=map(int,input().split())
    #n=int(input())
    #s=input()
    #s1=input()
    #p=input()
    #l=list(map(int,input().split()))
    #l.sort(revrese=True)
    #l2=list(map(int,input().split()))
    #l=str(n)
    #l.sort(reverse=True)
    #l2.sort(reverse=True)
    #l1.sort(reverse=True)
    #print(ans)
    (solve())           
        