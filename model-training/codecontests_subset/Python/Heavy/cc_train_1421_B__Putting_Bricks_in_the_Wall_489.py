t=int(input())
for k in range(t):
    n=int(input())
    grid=[]
    for i in range(n):
        grid.append(input())
    a,b,c,d=grid[0][1],grid[1][0],grid[n-1][n-2],grid[n-2][n-1]
    if a==b and c==d and a!=c:
        print(0)
    elif a==b and c!=d:
        print(1)
        if a==c:
            print(n,n-1)
        else:
            print(n-1,n)
    elif a!=b and c==d:
        print(1)
        if a==c:
            print(1,2)
        else:
            print(2,1)
    elif a==b==c==d:
        print(2)
        print(1,2)
        print(2,1)
    elif a==d and b==c and a!=b:
        print(2)
        print(1,2)
        print(n,n-1)
    elif a==c and b==d and a!=b:
        print(2)
        print(1,2)
        print(n-1,n)
