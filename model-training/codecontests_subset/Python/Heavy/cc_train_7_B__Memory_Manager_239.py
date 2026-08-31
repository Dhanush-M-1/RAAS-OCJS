import sys
import math
import collections
import heapq
input=sys.stdin.readline
t,m=(int(i) for i in input().split())
l=[-1]*m
k=0
for i in range(t):
    l1=[i for i in input().split()]
    if(l1[0]=='alloc'):
        l1[1]=int(l1[1])
        if(l1[1]>m):
            print("NULL")
        else:
            if(l.count(-1)==m):
                k+=1
                for i in range(l1[1]):
                    l[i]=k
                print(k)
            else:
                c=0
                c1=0
                s=m
                for i in range(m):
                    if(l[i]==-1):
                        if(c==0):
                            s=i
                        c+=1
                    else:
                        if(c>=l1[1]):
                            k+=1
                            for i in range(s,s+l1[1]):
                                l[i]=k
                            c1=1
                            c=0
                            break
                        else:
                            c=0
                if(c1==1):
                    print(k)
                else:
                    if(l[m-1]!=-1):
                        print("NULL")
                    else:
                        if(m-s>=l1[1]):
                            k+=1
                            for i in range(s,s+l1[1]):
                                l[i]=k
                            print(k)
                        else:
                            print("NULL")
    elif(l1[0]=='erase'):
        l1[1]=int(l1[1])
        if(l1[1] not in l or l1[1]<=0):
            print("ILLEGAL_ERASE_ARGUMENT")
        else:
            k1=l.index(l1[1])
            for i in range(k1,m):
                if(l[i]==l1[1]):
                    l[i]=-1
                else:
                    break
    else:
        l2=[]
        c=0
        for i in range(m):
            if(l[i]!=-1):
                l2.append(l[i])
                c+=1
        l=l2+[-1]*(m-c)