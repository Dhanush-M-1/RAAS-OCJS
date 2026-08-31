n,m=int(input()),0
x=list(map(int,input().split()))
y=[i-1 for i in x]
y.append(1000000-i for i in x)
for i in x:
    m=max(m,min(i-1,1000000-i))
print(m)