def solve():
    n=int(input())
    mat=[]
    for i in range(n):
        mat.append(input())
    x1 = mat[0][1]
    x2 = mat[1][0]
    y1 = mat[n - 2][n - 1]
    y2 = mat[n - 1][n - 2]
    if (x1 == x2 and y1 == y2 and x1 != y1):
        print(0)
        return
    if (x1 == x2 and y1 == y2):
        print(2)
        print("1 2")
        print("2 1")
        return
    if (x1 == x2):
        print(1)
        if (y1 == x1):
            print(n-1,end=" ")
            print(n)
            return
        if (y2 == x1):
            print(n,end=" ")
            print(n-1)
            return
    if (y1 == y2):
        print(1)
        if (x1 == y1):
            print("1 2")
            return
        if (x2 == y1):
            print("2 1")
            return
    if (x1 == y2):
        print(2)
        print("1 2")
        print(n-1,end=" ")
        print(n)
        return
    if (x1 == y1):
        print(2)
        print("1 2")
        print(n,end=" ")
        print(n-1)
t=int(input())
for _ in range(t):
    solve()