n, m = map(int,input().split())
lis=[0]*m
for i in range(n):
    templist=list(map(int,input().split()))
    for j in templist[1::]:lis[j-1]+=1
for i in range(m):
    if(lis[i]==0):
        print("NO")
        break
else:print("YES")