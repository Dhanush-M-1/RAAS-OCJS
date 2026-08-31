n,m=map(int,input().split());a,b=dict([[i+1,0] for i in range(m)]),'YES'
for i in range(n):
    for j in list(map(int,input().split()))[1:]:a[j]=1
for i in range(m):
    if a[i+1]!=1:b='NO'
print(b)