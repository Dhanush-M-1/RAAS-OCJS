import sys
from itertools import permutations
#a=list(map(int,input().strip().split(' ')))
#n,k,s= map(int, sys.stdin.readline().split(' '))    
n=int(input())
a=list(map(int,input().strip().split(' ')))
m=(pow(10,6))//2
t1=0
t2=0
for i in range(n):
    if(a[i]<=m):
        if(a[i]==m):t1=m-1
        else:
            t1=a[i]-1
    else:break
    
for i in range(n):
    if(a[i]>m):
        t2=pow(10,6)-a[i]
        break
print(max(t1,t2))

    
   

    

