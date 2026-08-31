
#k=int(input())
#n,m=map(int,input().split())

#a=list(map(int,input().split()))

#b=list(map(int,input().split()))

import collections

n=input()

a=[0]*3


for i in range(3):
    a[i]=sum(list(map(int,input().split())))

print(a[0]-a[1])
print(a[1]-a[2])

