n=int(input())
tree=[]
for i in range(n):
    tree.append([int(x) for x in input().split()])
tree.sort(key=lambda x:(x[0],x[1]))
tree.append([2*(10**9)+1,0])
l=1
if tree[1][0]-tree[0][0]>tree[0][1]:
    r=1
else:
    r=0
for j in range(1,n):
    l0=l
    if tree[j-1][0]+tree[j-1][1]<tree[j][0]-tree[j][1]:
        l=max(l+1,r+1)
    elif tree[j][0]-tree[j-1][0]>tree[j][1]:
        l=max(l+1,r)
    else:
        l=max(l,r)
    if tree[j+1][0]-tree[j][0]>tree[j][1]:
        r=max(l0+1,r+1)
    else:
        r=max(r,l0)
print(max(l,r))    