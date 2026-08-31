n = int(input())
x, h = [0], [0]
for i in range(n):
    xi, hi = [int(x) for x in input().split()]
    x.append(xi)
    h.append(hi)
maxt = [[0,0] for i in range(n+1)]
maxt[1] = [1,1]
for i in range(2,n+1):
    if x[i]-x[i-1]<=h[i-1]:
        maxt[i][1] = 1+maxt[i-1][0]
        if x[i]-x[i-1]<=h[i]:
            maxt[i][0] = maxt[i-1][0]
        else:
            maxt[i][0] = maxt[i-1][0]+1
    else:
        maxt[i][1] = 1+maxt[i-1][1]
        if x[i]-x[i-1]<=h[i]:
            maxt[i][0] = maxt[i-1][1]
        elif h[i]<x[i]-x[i-1]<=h[i]+h[i-1]:
            maxt[i][0] = max(1+maxt[i-1][0],maxt[i-1][1])
        else:
            maxt[i][0] = 1+maxt[i-1][1]
print(maxt[n][1])