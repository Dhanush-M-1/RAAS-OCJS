n=int(input())
errornum=[]
for i in range(3):
    error=list(map(int,input().split( )))
    a=sum(error)
    errornum.append(a)

for j in range(1,3):
    solve=errornum[j-1]-errornum[j]
    print(solve)