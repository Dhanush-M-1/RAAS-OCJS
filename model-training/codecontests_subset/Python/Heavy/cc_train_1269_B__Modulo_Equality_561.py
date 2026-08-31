import sys     
import math as mt
import bisect
input=sys.stdin.readline
#t=int(input())
t=1  
def solve():
    for i in range(len(ans)):
        d2={}
        for j in range(n):
            d2[(l[j]+ans[i])%m]=d2.get(((l[j]+ans[i])%m),0)+1
        if d2==cnt1:
            return ans[i]
   
for _ in range(t):
    #n=int(input())
    n,m=map(int,input().split())
    #x,y,k=map(int,input().split())
    #n,h=(map(int,input().split()))
    l=list(map(int,input().split()))
    l1=list(map(int,input().split()))
    d={}
    d1={}
    cnt={}
    for i in range(n):
        cnt[l[i]]=cnt.get(l[i],0)+1
    cnt1={}
    for i in range(n):
        cnt1[l1[i]]=cnt1.get(l1[i],0)+1
    
    for  i in cnt:
        if d.get(cnt[i],-1)==-1:
            d[cnt[i]]=[]
        d[cnt[i]].append(i)
    
    for  i in cnt1:
        if d1.get(cnt1[i],-1)==-1:
            d1[cnt1[i]]=[]
        d1[cnt1[i]].append(i)
    mini=n+1
    
    for i in d1:
        if len(d1[i])<mini:
            mini=len(d1[i])
            ind=i
    ans=[]
    for j1 in range(len(d[ind])):
        ans.append((d1[ind][0]-d[ind][j1])%m)
    ans.sort()
    print(solve())
    
    
            
            