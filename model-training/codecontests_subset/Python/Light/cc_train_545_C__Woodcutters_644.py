case=int(input())
num=0
tree=[[0,0]for i in range(case)]
for i in range(case):
    tree[i][0],tree[i][1]=map(int,input().split())
for i in range(1,case-1):
    if tree[i][0]-tree[i][1]>tree[i-1][0]:
        num+=1
    elif tree[i][0]+tree[i][1]<tree[i+1][0]:
        num+=1
        tree[i][0]+=tree[i][1]

print([case,num+2][case>=2])