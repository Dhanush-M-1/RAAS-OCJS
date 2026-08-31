n,m = map(int,input().split())
lii=[0]*(m+1)
for _ in range(n):
    li = list(map(int,input().split()))
    for i in range(1,len(li)):
        lii[li[i]]=1
for i in range(1,m+1):
    if lii[i]==0:
        print("NO")
        exit()
print('YES')