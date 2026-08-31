
n,m=map(int,input().split())
ar={}
for i in range(m):
    ar[i+1]=0
arr=[]
for __ in range(n):
    arr.append(list(map(int,input().split())))
for i in range(n):
    for j in range(1,arr[i][0]+1):
        ar[arr[i][j]]=1
if(0 in ar.values()):
    print("NO")
else:
    print("YES")