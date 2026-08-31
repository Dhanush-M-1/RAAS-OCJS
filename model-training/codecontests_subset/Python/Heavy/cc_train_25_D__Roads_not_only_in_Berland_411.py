import math
import sys

n = int(input())

g = []
fa = [i for i in range(0,n+1)]
value = [0 for i in range(0,n+1)]
num = [1 for i in range(0,n+1)]

vec = []
def getfa(x):
    if x == fa[x]:
        return x
    else:
        root = getfa(fa[x])
        fa[x] = root
        return fa[x]

for i in range(n-1):
    u,v = map(int, list(input().strip().split(" ")))
    g.append([u,v])

for edge in g:
    u = edge[0]
    v = edge[1]
    f1 = getfa(u)
    f2 = getfa(v)
    if f1 > f2:
        tmp = f1
        f1 = f2
        f2 = tmp
    if f1 != f2:
        fa[f2] = f1
        value[f1] += value[f2] + 1
        num[f1] += num[f2]
    elif f1 == f2:
        value[f1] += 1
        vec.append((u,v))

ans = 0
pos = -1
op = []
op1 = []

for i in range(1,n+1):
    if i == getfa(fa[i]):
        ans += 1
        # print("i = ",i)
        # print("va = ",value[i],"num = ",num[i])
        if num[i] > value[i]:
            op.append(i)
        # print("i = ",i," value = ",value[i]," num = ",num[i])
        if num[i] <= value[i]:
            op1.append(i)

print(ans-1)
if len(vec) == 0:
    exit(0)

# print(op)
# print(op1)
now = 0
cnt = 0
siz = len(op)
for i in range(0,len(vec)):
    if now != siz-1:
        print(vec[i][0],vec[i][1],op[now],op[now+1])
        now += 1
    else:
        print(vec[i][0],vec[i][1],op1[cnt],op[now])
        cnt += 1

"""
10
1 2
1 3
2 3
4 5
5 6
6 7
4 7
8 9
9 10

7 
1 2 
2 3 
3 1 
4 5 
5 6 
6 7

39
6 13
15 39
10 35
31 28
4 21
12 39
3 7
3 13
6 1
5 14
36 28
12 15
18 38
30 29
19 34
36 16
20 22
8 13
38 32
26 39
21 37
1 7
15 27
12 26
8 3
6 14
29 2
25 23
32 21
5 16
32 25
6 8
13 10
23 30
34 37
29 33
28 14
36 5

"""