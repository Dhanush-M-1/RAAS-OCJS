n,m=map(int,input().split(" "))
L=[0]*(m)
for k in range(n):
    i=0
    for j in map(int,input().split(" ")):
        if(i!=0):
            L[j-1]=1
        i+=1
if(sum(L)==m):
    print("YES")
else:
    print("NO")