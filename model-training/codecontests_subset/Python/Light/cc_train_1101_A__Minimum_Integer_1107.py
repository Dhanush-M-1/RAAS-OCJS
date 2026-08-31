q=int(input())
ans=[]
for i in range(q):
    l,r,d=map(int, input().split())
    j=1
    if (d<l or d>r):
        ans.append(d)
    else:
        ans.append((r//d+1)*d)
for i in range(q):
    print(ans[i])