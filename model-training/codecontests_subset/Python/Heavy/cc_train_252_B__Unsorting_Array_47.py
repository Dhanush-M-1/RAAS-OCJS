import random
import sys
n=int(sys.stdin.readline())

L=list(map(int,sys.stdin.readline().split()))
X=sorted(L)
XX=sorted(L,reverse=True)
K={}

for i in range(n):
    item=L[i]
    if(item in K):
        K[item].append(i)
    else:
        K[item]=[i]
if(len(X)<=2 or X[0]==X[-1] or (len(X)==3 and (L==[X[0],X[-1],X[0]] or L==[X[-1],X[0],X[-1]]))):
    print(-1)

else:
    x=X[0]
    y=X[-1]
    a=random.randint(0,len(K[x])-1)
    b=random.randint(0,len(K[y])-1)
    a=K[x][a]
    b=K[y][b]
    L[a],L[b]=L[b],L[a]
    while(L==X or L==XX):
        L[a],L[b]=L[b],L[a]
        a=random.randint(0,len(K[x])-1)
        b=random.randint(0,len(K[y])-1)
        a=K[x][a]
        b=K[y][b]
        L[a],L[b]=L[b],L[a]
    print(a+1,b+1)
