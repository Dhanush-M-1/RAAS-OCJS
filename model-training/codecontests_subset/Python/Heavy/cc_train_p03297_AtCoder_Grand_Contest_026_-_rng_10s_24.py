#
import sys

n = int(input())
a=[]
b=[]
c=[]
d=[]
for j in range(0,n):
    t1,t2,t3,t4 = (int(i) for i in input().split())  
    a.append(t1)
    b.append(t2)
    c.append(t3)
    d.append(t4)
    
for i in range(0,n):
    if a[i] < b[i]:
        print("No")
    elif d[i] < b[i]:
        print("No")
    else:
        p= b[i]
        q= d[i]
        while p%q :
            r=q
            q=p%q
            p=r
        if (b[i]-q)+a[i]%q > c[i]:
            print("No")
        else:
            print("Yes")
    

