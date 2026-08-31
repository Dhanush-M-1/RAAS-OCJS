def solve(n,trees):
    if n==1:return 1
    elif n==2:return 2
    ans=2;l=trees[0][0]
    for i in range(1,n-1):
        x=trees[i][0];h=trees[i][1]
        if x-h>l:ans+=1;l=x
        elif x+h<trees[i+1][0]:ans+=1;l=x+h
        else: l=trees[i][0]
    return ans
n=int(input());trees=[]
for i in range(n):
    a,x=map(int,input().split())
    trees.append([a,x])
print(solve(n,trees))