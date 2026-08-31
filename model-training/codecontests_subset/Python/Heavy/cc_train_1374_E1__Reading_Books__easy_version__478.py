
import sys
# from collections import defaultdict
# t=1
# t=int(input())

def fun(x):
    # print(x)
    return x[0]

n,k=list(map(int,sys.stdin.readline().strip().split()))
xx=[]

a=[]
b=[]
c=[]
for i in range(n):
    # n=int(input())
    x=list(map(int,sys.stdin.readline().strip().split()))
    # a,b,c,d=list(sys.stdin.readline().strip().split())
    # n,k=list(map(int,sys.stdin.readline().strip().split()))
    # xx.append(x)
    
    if(x[1]==x[2]==1):
        a.append(x[0])
    elif(x[1]==1):
        b.append(x[0])
    elif(x[2]==1):
        c.append(x[0])
    
# a=k
# b=k
# # print(xx)
# xx.sort(key=fun)
# # print(xx)
# op=0

# for i in xx:
#     if()

b.sort()
c.sort()
for i in range(min(len(b),len(c))):
    a.append(b[i]+c[i])
a.sort()

if(len(a)<k):
    print(-1)
else:
    print(sum(a[:k]))