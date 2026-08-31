from collections import *
n=int(input())
l=list(map(int,input().split()))
arr=list(map(int,input().split()))
m=list(map(int,input().split()))
d=Counter(l)
d1=Counter(arr)
d2=Counter(m)
#print(d,d1,d2)
ans=[]
cnt=0
for i in d:
    if(d[i]>d1.get(i,0)):
        #print(i,d[i],d1.get(i,0))
        ans.append(i)
        break
for i in d1:
    if(d1[i]>d2.get(i,0)):
        #print(i,d1[i],d2.get(i,0))
        ans.append(i)
        break
for i in ans:
    print(i)