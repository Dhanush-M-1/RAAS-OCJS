n=int(input())
count=min(n,2)
p=[[0 for j in range(2)]for k in range(n)]
dis=[]
for i in range(n):
    x,h=map(int,input().split())
    p[i][0] = x
    p[i][1] = h
for m in range(1,n):
    dis.append(p[m][0]-p[m-1][0])
for g in range(n-2):
    if (p[g+1][1]<dis[g]):
        dis[g] = dis[g] - p[g+1][1]
        count += 1
    else:
        if(p[g+1][1]<dis[g+1]):
            dis[g+1] = dis[g+1] - p[g+1][1]
            count += 1
print (count)