import sys
import math
from collections import defaultdict,Counter

# input=sys.stdin.readline
# def print(x):
#     sys.stdout.write(str(x)+"\n")

# sys.stdout=open("CP1/output.txt",'w')
# sys.stdin=open("CP1/input.txt",'r')

# m=pow(10,9)+7
# t=int(input())
# for i in range(t):
n=int(input())
a=1
b=1
# d=defaultdict(int)
d=[]
tot=1
cur=1
while n%2==0:
    cur*=2
    tot*=2
    # d[2]+=1
    n//=2
if cur!=1:
    d.append(cur)
    cur=1
if a!=1:
    flag=0
else:
    flag=1
for i in range(3,int(math.sqrt(n))+1,2):
    if n%i==0 and flag==0:
        while n%i==0:
            cur*=i
            tot*=i
            # d[i]+=1
            n//=i
        d.append(cur)
        cur=1
        if a<=b:
            flag=1
    elif n%i==0 and flag==1:
        while n%i==0:
            cur*=i
            tot*=i
            # d[i]+=1
            # a*=i
            n//=i
        d.append(cur)
        cur=1
        if b<a:
            flag=0

if n>2:
    d.append(n)
    tot*=n
    # d[n]+=1
    # if flag==0:
    #     b*=n
    # else:
    #     a*=n
# d.sort(reverse=True)
# pre=[1]*len(d)
if tot==1:
    print(1,1)
else:
    a=1
    b=tot
    ans=tot
    for i in range(pow(2,len(d))):
        cur=1
        for j in range(len(d)):
            if i&1<<j:
                cur*=d[j]

        if max(cur,tot//cur)<ans:
            ans=max(cur,tot//cur)
            a=cur
            b=tot//cur

    print(a,b)
    # print(a*b)
# print(2*3*5*7*11*13*17*19*23*29*31)