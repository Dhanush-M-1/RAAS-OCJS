from collections import deque
import sys
t = int(input())
for i in range(t):
    n = int(input())
    edge = {}
    for j in range(1,n+1):
        a = set()
        edge[j] = a
    for k in range(n-1):
        a,b = map(int,input().split())
        edge[a].add(b)
        edge[b].add(a)
    k1 = int(input())
    x = input().split()
    mysubg = set()
    for j in range(len(x)):
        mysubg.add(int(x[j]))
    k2 = int(input())
    y = input().split()
    notmysubg = set()
    for j in range(len(y)):
        notmysubg.add(int(y[j]))
    root = int(x[0])
    print("B "+y[0])
    sys.stdout.flush()
    goal = int(input())
    d = deque([root])
    visit = set()
    parent = {}
    while len(d) > 0:
        cur = d.popleft()
        for neigh in edge[cur]:
            if neigh not in visit:
                visit.add(neigh)
                d.append(neigh)
                parent[neigh] = cur
    while goal != root:
        if goal in mysubg:
            break
        goal = parent[goal]
    print("A "+str(goal))
    sys.stdout.flush()
    goal2 = int(input())
    if goal2 in notmysubg:
        print("C "+str(goal))
    else:
        print("C -1")
