n,m=map(int,input().split())
ans=set()
for i in range(n):
    inp=list(map(int,input().split()))
    for j in range(1,inp[0]+1):
        if inp[j] in ans:
            continue
        else:
            ans.add(inp[j])
if len(ans)==m:
    print("YES")
else:
    print("NO")