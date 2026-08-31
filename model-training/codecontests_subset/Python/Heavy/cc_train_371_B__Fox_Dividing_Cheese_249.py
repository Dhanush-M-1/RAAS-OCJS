import sys
import math
input=sys.stdin.readline
a,b=(int(i) for i in input().split())
l1,l2=[0,0,0],[0,0,0]
while(a>1):
    if(a%2==0):
        l1[0]+=1
        a//=2
    elif(a%3==0):
        l1[1]+=1
        a//=3
    elif(a%5==0):
        l1[2]+=1
        a//=5
    else:
        break
while(b>1):
    if(b%2==0):
        l2[0]+=1
        b//=2
    elif(b%3==0):
        l2[1]+=1
        b//=3
    elif(b%5==0):
        l2[2]+=1
        b//=5
    else:
        break
if(a!=b):
    print(-1)
else:
    print(abs(l1[0]-l2[0])+abs(l1[1]-l2[1])+abs(l1[2]-l2[2]))