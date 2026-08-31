# import sys
# sys.stderr=open('err.txt','w')
# sys.stdout=open('output.txt','w')
# sys.stdin=open('input.txt','r')

def make_set(v):
    parent[v]=v
    rank[v]=1

def find_set(a):
    if parent[a]==a:
        return a
    parent[a]=find_set(parent[a])
    return parent[a]

def union_set(a,b):
    x=find_set(a)
    y=find_set(b)
    if x==y:
        return
    if rank[x]>rank[y]:
        parent[y]=x
        rank[x]+=rank[y]
    else:
        parent[x]=y
        rank[y]+=rank[x]

n=int(input())
a=[_ for _ in range(1,n+1)]
parent=[0]*n
rank=[0]*n

for i in a:
    make_set(i-1)
t=[]
for i in range(n-1):
    p,q=map(int,input().split(' '))

    if find_set(p-1)==find_set(q-1):
        t.append((p-1,q-1))
    else:
        union_set(p-1,q-1)
#print(parent)
#print(rank)
#print(t)
# u=[]
# for i in parent:
#     if i not in u:
#         u.append(i)
# x=len(t)
# if len(u)<=1:
#     print("0")
# else:
#     for i in range(1,len(u)):
#         if x>0:
#             print(str(t[0][0]+1)+" "+str(t[0][1]+1)+" "+str(t[0][1]+1)+" "+str(u[i]+1))
d=[]
for i in range(2,n+1):
    if find_set(i-1)!=find_set(0):
        union_set(i-1,0)
        d.append((i,1))
y=len(t)
print(len(d))
for i in d:
    if y>0:
        print(str(t[len(t)-y][0]+1)+" "+str(t[len(t)-y][1]+1)+" "+str(i[0])+" "+str(i[1]))
        y-=1
