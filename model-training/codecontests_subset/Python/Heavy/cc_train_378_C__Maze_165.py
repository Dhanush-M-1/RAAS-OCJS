import sys
import math
import collections
import heapq
import decimal
n,m,k=(int(i) for i in input().split())
l=[]
for i in range(n):
    l.append(list(input()))
def neighbours(x,y):
    global n
    global m
    global l
    l1=[]
    if(x-1>=0 and l[x-1][y]=='.'):
        l1.append((x-1,y))
    if(x+1<=n-1 and l[x+1][y]=='.'):
        l1.append((x+1,y))
    if(y-1>=0 and l[x][y-1]=='.'):
        l1.append((x,y-1))
    if(y+1<=m-1 and l[x][y+1]=='.'):
        l1.append((x,y+1))
    return l1
d={}
c1=0
for i in range(n):
    for j in range(m):
        d[(i,j)]=[]
for i in range(n):
    for j in range(m):
        if(l[i][j]=='.'):
            c1+=1
            nbd=neighbours(i,j)
            for x in nbd:
                d[(i,j)].append(x)
c=0
v=[[0 for i in range(m)] for j in range(n)]
if(c1==0):
    for i in range(n):
        print(''.join(l[i]))
else:
    queue=[]
    for i in range(n):
        if(c==1):
            break
        for j in range(m):
            if(l[i][j]=='.'):
                queue.append((i,j))
                l[i][j]='X'
                v[i][j]=1
                c+=1
                break
    while(queue!=[]):
        if(c==c1-k):
            break
        s=queue.pop(0)
        for j in d[s]:
            if(c==c1-k):
                break
            if(v[j[0]][j[1]]==0):
                v[j[0]][j[1]]=1
                l[j[0]][j[1]]='X'
                c+=1
                queue.append(j)
    for i in range(n):
        for j in range(m):
            if(l[i][j]=='X'):
                l[i][j]='.'
            elif(l[i][j]=='.'):
                l[i][j]='X'
    for i in range(n):
        print(''.join(l[i]))