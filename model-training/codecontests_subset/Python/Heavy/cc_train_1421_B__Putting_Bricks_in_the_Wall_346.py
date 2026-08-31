def solve():
    # put code here
    n=int(input())
    mat=[]
    for _ in range(n):
        mat.append(input())
   
    if (mat[0][1] != mat[1][0] and
        mat[n-2][n-1] != mat[n-1][n-2]):
        print(2)
        if mat[0][1]=='0':
            print(1,2)
        else:
            print(2,1)
        if mat[n-2][n-1] == '1':
            print(n-1,n)
        else:
            print(n,n-1)
    elif (mat[0][1] == mat[1][0] and
          mat[n-2][n-1]!=mat[n-1][n-2]):
        print(1)
        if mat[0][1]==mat[n-2][n-1]:
            print(n-1, n)
        else:
            print(n, n-1)
    elif (mat[n-2][n-1] == mat[n-1][n-2] and
          mat[0][1] != mat[1][0]):
        print(1)
        if mat[n-2][n-1]==mat[0][1]:
            print(1,2)
        else:
            print(2,1)
    elif (mat[n-2][n-1] == mat[n-1][n-2] and
          mat[0][1] == mat[1][0] and
          mat[n-2][n-1] == mat[0][1]):
        print(2)
        print(1,2)
        print(2,1)
    elif (mat[n-2][n-1] == mat[n-1][n-2] and
          mat[0][1] == mat[1][0] and
          mat[n-2][n-1] != mat[0][1]):
        print(0)
    else:
        raise Exception
    #print('\n')

t = int(input())
for _ in range(t):
    solve()
