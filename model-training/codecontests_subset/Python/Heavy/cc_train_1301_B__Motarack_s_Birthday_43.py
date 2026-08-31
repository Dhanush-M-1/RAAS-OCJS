#extra registration after 10 minutes.

import sys
# from collections import defaultdict
# t=1
t=int(input())
for i in range(t):
    n=int(input())
    # n,m=list(map(int,sys.stdin.readline().strip().split()))
    # a=list(sys.stdin.readline().strip().split())
    b=list(map(int,sys.stdin.readline().strip().split()))
    x=0
    f=1
    c=0
    cc=0
    # arr=[]
    # for j in b:
    #     if(j>-1):
    #         x+=j
    #         f=0
    #         arr.append(j)
    #     else:
    #         c+=1
    a=[0]+b.copy()+[0]
    zzzz=set()
    for j in range(1,n+1):
        if(a[j]>-1):
            f=0
        else:
            c+=1
        if(a[j]>-1 and (a[j-1]==-1 or a[j+1]==-1)):
            # x+=a[j]
            zzzz.add(a[j])
            cc+=1
    if(f):
        print(0,0)
        continue
    
    # z=x//cc
    # z=sum(zzzz)//len(zzzz)
    
    z=min(zzzz)+(max(zzzz)-min(zzzz))//2
    # print(z,zzzz)
        # zz=z*c+x
    # zz=10**9
    # op=z
    b1=[]
    b2=[]
    b3=[]
    b4=[]
    b5=[]
    for j in b:
        if(j>-1):
            b1.append(j)
            b2.append(j)
            
            b3.append(j)
            b4.append(j)
            b5.append(j)
        else:
            b1.append(z)
            b2.append(z+1)
            
            # b2.append(j)
            b3.append(z+2)
            b4.append(z-1)
            b5.append(z-2)
    op1=0
    op2=0
    op3=0
    
    op4=0
    op5=0
    for j in range(1,n):
        op1=max(op1,abs(b1[j]-b1[j-1]))
        op2=max(op2,abs(b2[j]-b2[j-1]))
        op3=max(op3,abs(b3[j]-b3[j-1]))
        op4=max(op4,abs(b4[j]-b4[j-1]))
        op5=max(op5,abs(b5[j]-b5[j-1]))
    # if(op1<op2):
    #     print(op1,z)
    # else:
    #     print(op2,z+1)
    
    oop=min([op1,op2,op3,op4,op5])
    op=[op1,op2,op3,op4,op5]
    # print(op,b2)
    opact=[z,z+1,z+2,z-1,z-2]
    for j in range(5):
        if(oop==op[j]):
            print(op[j],opact[j])
            break
        
        
            