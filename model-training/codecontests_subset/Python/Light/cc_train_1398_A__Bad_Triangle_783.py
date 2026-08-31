t= int(input())
ans=[]
for i in range(t):
    n= int(input())
    d=[int(i) for i in input().split()]
    q=1
    x,y=d[0],d[1]
    for j in range(2,n):
        if (x+y)<=d[j]:
            ans.append((1,2,j+1))
            q=0
            break
    if q!=0:
        ans.append(-1)

for i in ans:
    if i!=-1:
        print(i[0],i[1],i[2])
    else:
        print(i)
    