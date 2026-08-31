n=int(input())
tree={}
for i in range(n-1):
    a,b=[int(x) for x in input().split()]
    if a not in tree:
        tree[a]=1
    else:
        tree[a]+=1
    if b not in tree:
        tree[b]=1
    else:
        tree[b]+=1
for item in tree:
    if tree[item]==2:
        print('NO')
        break
else:
    print('YES')
    
