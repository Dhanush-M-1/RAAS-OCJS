n=int(input())
trees=[list(map(int,input().split())) for _ in range(n)]
c=min(2,n)            #left,right tress can be made to fall with no restrctn
for i in range(1,n-1):
    if trees[i][0]-trees[i][1]>trees[i-1][0]:
        c+=1 
    elif trees[i][0]+trees[i][1]<trees[i+1][0]:
        trees[i][0]+=trees[i][1]
        c+=1 
print(c)