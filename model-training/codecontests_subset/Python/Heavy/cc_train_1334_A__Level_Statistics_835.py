import math
def dtb(n): 
    return bin(n).replace("0b","")
def btd(n): 
    return int(n,2) 
t=int(input())
for k in range(t):
    n=int(input())
    p0,c0=0,0
    flag=0
    for i in range(n):
        p,c=map(int,input().split())
        if p>=p0 and c>=c0:
            if(p>=c):
                if(p-p0>=c-c0):
                    p0=p
                    c0=c
                else:
                    flag=1
            else:
                flag=1
        else:
            flag=1
    if flag==1:
        print("NO")
    else:
        print("YES")
    