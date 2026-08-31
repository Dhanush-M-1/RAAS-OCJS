from math import *
from collections import *
from bisect import *
import sys
input=sys.stdin.readline
t=1
while(t):
    t-=1
    n,k1=map(int,input().split())
    oo=[]
    al=[]
    bob=[]
    for i in range(n):
        a=list(map(int,input().split()))
        if(a[-1]==a[-2]==1):
            oo.append(a[0])
        elif(a[-1]==0 and a[-2]==1):
            al.append(a[0])
        elif(a[-1]==1 and a[-2]==0):
            bob.append(a[0])
    oo.sort()
    bob.sort()
    al.sort()
    i,j,k=0,0,0
    ak,bk=k1,k1
    rr=0
    l1,l2,l3=len(oo),len(al),len(bob)
    gb=0
    while((ak>0 or bk>0) and (i<l1 or j<l2 or k<l3)):
        if(gb>n):
            break
        if(i<l1):
            if(j<l2 and k<l3):
                if(oo[i]<=bob[k]+al[j]):
                    ak-=1
                    bk-=1
                    rr+=oo[i]
                    i+=1
                elif(bk<=0):
                    if(oo[i]<=al[j]):
                        rr+=oo[i]
                        i+=1
                        ak-=1
                        bk-=1
                    else:
                        rr+=al[j]
                        j+=1
                        ak-=1
                elif(ak<=0):
                    if(oo[i]<=bob[k]):
                        rr+=oo[i]
                        i+=1
                        ak-=1
                        bk-=1
                    else:
                        rr+=bob[k]
                        bk-=1
                        k+=1
                else:
                    rr+=bob[k]+al[j]
                    k+=1
                    j+=1
                    ak-=1
                    bk-=1
            elif(j<l2 and k>=l3):
                if(bk<=0):
                    if(oo[i]<=al[j]):
                        rr+=oo[i]
                        ak-=1
                        bk-=1
                        i+=1
                    else:
                        rr+=al[j]
                        j+=1
                        ak-=1
                else:
                    rr+=oo[i]
                    i+=1
                    ak-=1
                    bk-=1
            elif(j>=l2 and k<l3):
                if(ak<=0):
                    if(oo[i]<=bob[k]):
                        rr+=oo[i]
                        i+=1
                        bk-=1
                        ak-=1
                    else:
                        rr+=bob[k]
                        k+=1
                        bk-=1
                else:
                    rr+=oo[i]
                    i+=1
                    ak-=1
                    bk-=1
            else:
                rr+=oo[i]
                i+=1
                ak-=1
                bk-=1
        else:
            if(ak>0 and j<l2):
                rr+=al[j]
                j+=1
                ak-=1
            if(bk>0 and k<l3):
                rr+=bob[k]
                k+=1
                bk-=1
        gb+=1
    if(ak<=0 and bk<=0):
        print(rr)
    else:
        print(-1)
                
            
                    
                    
