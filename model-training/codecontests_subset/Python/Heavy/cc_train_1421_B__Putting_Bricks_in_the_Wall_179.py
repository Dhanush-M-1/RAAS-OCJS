'''Author- Akshit Monga'''
t=int(input())
for _ in range(t):
    n=int(input())
    mat=[[0for y in range(n)] for x in range(n)]
    for i in range(n):
        s=input()
        for j in range(n):
            mat[i][j]=s[j]
    if mat[0][1]==mat[1][0]=='0':
        if mat[n-2][n-1]==mat[n-1][n-2]=='1':
            print(0)
            continue
        elif mat[n-2][n-1]==mat[n-1][n-2]=='0':
            print(2)
            print(n-1,n)
            print(n,n-1)
            continue
        elif mat[n-2][n-1]=='1' and mat[n-1][n-2]=='0':
            print(1)
            print(n,n-1)
            continue
        elif mat[n-2][n-1]=='0' and mat[n-1][n-2]=='1':
            print(1)
            print(n-1,n)
            continue
    if mat[0][1]==mat[1][0]=='1':
        if mat[n-2][n-1]==mat[n-1][n-2]=='0':
            print(0)
            continue
        elif mat[n-2][n-1]==mat[n-1][n-2]=='1':
            print(2)
            print(n-1,n)
            print(n,n-1)
            continue
        elif mat[n-2][n-1]=='0' and mat[n-1][n-2]=='1':
            print(1)
            print(n,n-1)
            continue
        elif mat[n-2][n-1]=='1' and mat[n-1][n-2]=='0':
            print(1)
            print(n-1,n)
            continue
    if mat[0][1]=='1' and mat[1][0]=='0':
        if mat[n-2][n-1]==mat[n-1][n-2]=='1':
            print(1)
            print(1,2)
            continue
        elif mat[n-2][n-1]==mat[n-1][n-2]=='0':
            print(1)
            print(2,1)
            continue
        elif mat[n-2][n-1]=='1' and mat[n-1][n-2]=='0':
            print(2)
            print(1,2)
            print(n,n-1)
            continue
        elif mat[n-2][n-1]=='0' and mat[n-1][n-2]=='1':
            print(2)
            print(2,1)
            print(n,n-1)
            continue
    if mat[0][1]=='0' and mat[1][0]=='1':
        if mat[n-2][n-1]==mat[n-1][n-2]=='1':
            print(1)
            print(2,1)
            continue
        elif mat[n-2][n-1]==mat[n-1][n-2]=='0':
            print(1)
            print(1,2)
            continue
        elif mat[n-2][n-1]=='1' and mat[n-1][n-2]=='0':
            print(2)
            print(1,2)
            print(n-1,n)
            continue
        elif mat[n-2][n-1]=='0' and mat[n-1][n-2]=='1':
            print(2)
            print(1,2)
            print(n,n-1)
            continue