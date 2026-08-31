n=int(input())
for i in range(n):
    m,n,k=[int(x) for x in input().split()]
    if k<m or k>n:
        print(k)
    else:
        print(k*(n//k+1))
        
