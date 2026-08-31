n=int(input())
trees=[[int(i) for i in input().split()] for j in range(n)]
k=1
i=1
j=trees[0][0]
while i<n-1:
    if trees[i][1]<trees[i][0]-j:
        k+=1
        j=trees[i][0]
        i+=1
    else:
        if trees[i][1]<trees[i+1][0]-trees[i][0]:
            k+=1
            j=trees[i][0]+trees[i][1]
            i+=1
        else:
            j=trees[i][0]
            i+=1
if n>1:
    k+=1
print(k)