'''
    Auther: ghoshashis545 Ashis Ghosh
    College: jalpaiguri Govt Enggineerin College
    Date:13/04/2020
'''
from math import ceil,sqrt,log,gcd
def ii():return int(input())
def si():return input()
def mi():return map(int,input().split())
def li():return list(mi())
n=ii()
s=si()
a=[]
for i in range(n-1):
    a.append(s[i:(i+2)])
m={}
for i in a:
    if i not in m:
        m[i]=1
    else:
        m[i]+=1
maxi=0
for i in m.keys():
    if(m[i]>maxi):
        ans=i
        maxi=m[i]
print(ans)