n=int(input())
b=[(float('-inf'), 0)]
for _ in range(n):
    b.append(tuple(map(int,input().split())))
b.append((float('inf'),0))
d=[[0,0,0]]+[[0,0,0] for _ in range(n)]
for i in range(1,n+1):
    if b[i-1][0] < b[i][0]-b[i][1]:
        d[i][0]=max(d[i-1][0],d[i-1][1])+1
        if b[i-1][0]+b[i-1][1] < b[i][0]-b[i][1]:
            d[i][0]=max(d[i][0],d[i-1][2]+1)
    else: d[i][0]=-1

    d[i][1]=max(d[i-1])

    if b[i+1][0] > b[i][0]+b[i][1]:
        d[i][2]=max(d[i-1])+1
    else: d[i][2]=-1
print(max(d[n]))