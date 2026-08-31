from bisect import bisect_left
x0,y0,x1,y1=map(int,input().split())
n=int(input())
allowed={}
for i in range(n):
    r,a,b=map(int,input().split())
    if r-1 not in allowed:
        allowed[r-1]=[]
    allowed[r-1].append([a-1,b-1])
for each in allowed:
    i=0
    allowed[each].sort()
    while i<len(allowed[each])-1:
        if allowed[each][i][1]>=allowed[each][i+1][0]:
            allowed[each][i][1]=max(allowed[each][i][1],allowed[each][i+1][1])
            del allowed[each][i+1]
        else:
            i+=1
def code(x,y):
    return x*10**9+y
q=[[code(x0-1,y0-1),0]]
v={code(x0-1,y0-1)}
f=False
while q:
    node=q[0]
    x,y=node[0]//10**9,node[0]%(10**9)
    d=node[1]
    del q[0]
    if x==x1-1 and y==y1-1:
        f=True
        break
    #print(*[x,y])
    c=code(x+1,y)
    if c not in v and x<10**9-1 and x+1 in allowed:
        r=x+1
        i=bisect_left(allowed[r],[y,y])
        n=len(allowed[r])
        if (i!=n and allowed[r][i][0]==y) or (i>0 and allowed[r][i-1][1]>=y):
            q.append([c,d+1])
            v.add(c)
    c=code(x-1,y)
    if c not in v and x>0 and x-1 in allowed:
        r=x-1
        i=bisect_left(allowed[r],[y,y])
        n=len(allowed[r])
        if (i!=n and allowed[r][i][0]==y) or (i>0 and allowed[r][i-1][1]>=y):
            q.append([c,d+1])
            v.add(c)
    c=code(x,y+1)
    if c not in v and y<10**9-1 and x in allowed:
        r=x
        i=bisect_left(allowed[r],[y+1,y+1])
        n=len(allowed[r])
        if (i!=n and allowed[r][i][0]==y+1) or (i>0 and allowed[r][i-1][1]>=y+1):
            q.append([c,d+1])
            v.add(c)
    c=code(x,y-1)
    if c not in v and y>0 and x in allowed:
        r=x
        i=bisect_left(allowed[r],[y-1,y-1])
        n=len(allowed[r])
        if (i!=n and allowed[r][i][0]==y-1) or (i>0 and allowed[r][i-1][1]>=y-1):
            q.append([c,d+1])
            v.add(c)
    c=code(x+1,y+1)
    if c not in v and y<10**9-1 and x<10**9-1 and x+1 in allowed:
        r=x+1
        i=bisect_left(allowed[r],[y+1,y+1])
        n=len(allowed[r])
        if (i!=n and allowed[r][i][0]==y+1) or (i>0 and allowed[r][i-1][1]>=y+1):
            q.append([c,d+1])
            v.add(c)
    c=code(x+1,y-1)
    if c not in v and y>0 and x<10**9-1 and x+1 in allowed:
        r=x+1
        i=bisect_left(allowed[r],[y-1,y-1])
        n=len(allowed[r])
        if (i!=n and allowed[r][i][0]==y-1) or (i>0 and allowed[r][i-1][1]>=y-1):
            q.append([c,d+1])
            v.add(c)
    c=code(x-1,y+1)
    if c not in v and y<10**9-1 and x>0 and x-1 in allowed:
        r=x-1
        i=bisect_left(allowed[r],[y+1,y+1])
        n=len(allowed[r])
        if (i!=n and allowed[r][i][0]==y+1) or (i>0 and allowed[r][i-1][1]>=y+1):
            q.append([c,d+1])
            v.add(c)
    c=code(x-1,y-1)
    if c not in v and y>0 and x>0 and x-1 in allowed:
        r=x-1
        i=bisect_left(allowed[r],[y-1,y-1])
        n=len(allowed[r])
        if (i!=n and allowed[r][i][0]==y-1) or (i>0 and allowed[r][i-1][1]>=y-1):
            q.append([c,d+1])
            v.add(c)
if f:
    print(node[1])
else:
    print(-1)
