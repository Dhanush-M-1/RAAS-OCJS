# 改行でバグる時
import sys
input = lambda: sys.stdin.readline().rstrip()

t=int(input())
g=[]
for i in range(t):
    a=int(input())
    x=[]
    for j in range(a):
        b=list(input())
        x.append(b)
    g.append(x)

ans=[]
for i in range(t):
    v=len(g[i])
    x1=g[i][0][1]
    x2=g[i][1][0]
    y1=g[i][v-2][v-1]
    y2=g[i][v-1][v-2]
    if x1=='1' and x2=='1':
        if y1=='1' and y2=='1':
            ans.append([2,[v-1,v],[v,v-1]])
        elif y1=='1' and y2=='0':
            ans.append([1,[v-1,v]])
        elif y1=='0' and y2=='1':
            ans.append([1,[v,v-1]])
        else:
            ans.append(0)
    elif x1=='1' and x2=='0':
        if y1=='1' and y2=='1':
            ans.append([1,[1,2]])
        elif y1=='1' and y2=='0':
            ans.append([2,[2,1],[v-1,v]])
        elif y1=='0' and y2=='1':
            ans.append([2,[2,1],[v,v-1]])
        else:
            ans.append([1,[2,1]])
    elif x1=='0' and x2=='1':
        if y1=='1' and y2=='1':
            ans.append([1,[2,1]])
        elif y1=='1' and y2=='0':
            ans.append([2,[1,2],[v-1,v]])
        elif y1=='0' and y2=='1':
            ans.append([2,[1,2],[v,v-1]])
        else:
            ans.append([1,[1,2]])

    else:
        if y1=='1' and y2=='1':
            ans.append(0)
        elif y1=='1' and y2=='0':
            ans.append([1,[v,v-1]])
        elif y1=='0' and y2=='1':
            ans.append([1,[v-1,v]])
        else:
            ans.append([2,[1,2],[2,1]])


for i in range(t):
    if ans[i]!=0:
        x = ans[i][0]
        print(x)
        for j in range(x):
            print(*ans[i][j + 1])
    else:
        print(0)