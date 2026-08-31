import math
for _ in range(int(input())):

    n = int(input())

    
    mat = []

    for i in range(n):
        temp = input()
        mat.append(list(temp))

    #print(mat)

    a = mat[0][1]
    b = mat[1][0]
    c = mat[n-1][n-2]
    d = mat[n-2][n-1]

    #print(a,b,c,d)

    if a == b and c == d:
        if a != c:
            print(0)
        else:
            print(2)
            print(n,n-1)
            print(n-1,n)

    elif a == d and b == c:
        #print('x')
        print(2)
        print(1,2)
        print(n,n-1)
    elif a == c and b ==d and a!= b:
        #print('y')
        print(2)
        print(1,2)
        print(n-1,n)
    elif a == b and c != d:
        if c == a:
            print(1)
            print(n,n-1)
        elif d == a:
            print(1)
            print(n-1,n)
    elif c == d and a != b:
        if a == c:  
            print(1)
            print(1,2)
        elif c == b:
            print(1)
            print(2,1)
