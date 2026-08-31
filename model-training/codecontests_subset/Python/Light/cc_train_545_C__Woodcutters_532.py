n=int(input())
tree=[]
for i in range(n):
    x,h=map(int,input().split())
    tree.append((x,h))
cut=1
cordinate=tree[0][0]
for i in range(1,n-1):
    thistree=tree[i]
    nexttree=tree[i+1]
    if thistree[0]-thistree[1]>cordinate:
        cut+=1
        cordinate=thistree[0]
        continue
    if thistree[0]+thistree[1]<nexttree[0]:
        cut+=1
        cordinate=thistree[0]+thistree[1]
        continue
    cordinate=thistree[0]
if n==1:
    print("1")
else:
    print(cut+1)