import math


for _ in range(int(input())):
#n=int(input())
    a=[int(n) for n in input().split()]
    b=[]
    b+=a
#b=[int(n) for n in input().split()]
    c=0
    c1=0
    #print(*b)
    while b[1]>=1 and b[2]>=2:
        c1+=3
        b[1]-=1
        b[2]-=2
    while b[0]>=1 and b[1]>=2:
        c1+=3
        b[0]-=1 
        b[1]-=2
    while a[0]>=1 and a[1]>=2:
        c+=3
        a[0]-=1
        a[1]-=2
    while a[1]>=1 and a[2]>=2:
        c+=3
        a[1]-=1 
        a[2]-=2
    print(max(c,c1))