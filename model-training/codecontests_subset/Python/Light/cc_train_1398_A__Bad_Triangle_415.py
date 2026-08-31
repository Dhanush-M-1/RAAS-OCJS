for p in range(int(input())):
    n=int(input())
    x=[int(x) for x in input().split()]
    i,j,k=0,1,n-1
    a,b,c=x[i],x[j],x[k]
    if (a+b)>c:
        print(-1)
    else:
        print(i+1,j+1,k+1)