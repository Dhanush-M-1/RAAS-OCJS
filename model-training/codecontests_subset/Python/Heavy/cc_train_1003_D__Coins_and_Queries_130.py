from sys import stdin
from collections import Counter
# n,k=map(int,stdin.readline().strip().split())
# list1=list(map(int,stdin.readline().strip().split()))
n,k=map(int,input().split())

list1=list(map(int,input().split()))

list1.sort(reverse=True)
list2=[]
for i in range(n):
    if(list2):
        if(list1[i]==list2[-1][0]):
            list2[-1][1]+=1
        else:
            list2.append([list1[i],1])
    else:
        list2.append([list1[i],1])

l=len(list2)   
# if(n!=5):
#     print(l)
for _ in range(k):
    ele=int(stdin.readline())
    c=0
    for i in range(l):
        # print("Sd")
        x=list2[i][0]
        y=list2[i][1]
        if(ele>=x):
            s=ele//x
            cc=min(s,y)
            c+=cc
            ele-=(x*cc)
        if(not ele):
            break
    if(ele==0):
        print(c)
    else:
        print(-1)
