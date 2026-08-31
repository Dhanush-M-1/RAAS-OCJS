for tc in range(int(input())):
    n = int(input())
    mat = []
    for i in range(n):
        mat.append(input())
    # print(mat)
    
    x = mat[0][1]
    y = mat[1][0]
    p = mat[-1][-2]
    q = mat[-2][-1]

    if (x == y) and (p == q):
        if x == p:
            print('2')
            print('1 2')
            print('2 1')
        else:
            print('0')
    elif x == y:
        print('1')
        if p != x:
            print(n-1, n)
        elif q != x:
            print(n, n-1)
    elif p == q:
        print('1')
        if x != p:
            print('2 1')
        elif y != p:
            print('1 2')
    else:
        print('2')
        if x == p:
            print('1 2')
            print(n-1, n)
        else:
            print('1 2')
            print(n, n-1)



   