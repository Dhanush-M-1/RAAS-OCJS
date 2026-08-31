T = int(input())
M =[ [0 for i in range(300)] for j in range(300)]
for t in range(T):
    n = int(input())
    for i in range(n):
        a = input()
        for j in range(n):
            if a[j] != 'S' and a[j] != 'F':
                M[i][j] = int(a[j])
    res1 = []
    res0 = []
    if M[0][1] == 1:
        res0.append((1,2))
    else:
        res1.append((1,2))
    if M[1][0] == 1:
        res0.append((2,1))
    else:
        res1.append((2,1))
    if M[n-1][n-2] == 1:
        res1.append((n,n-1))
    else:
        res0.append((n,n-1))
    if M[n-2][n-1] == 1:
        res1.append((n-1,n))
    else:
        res0.append((n-1, n))
    if len(res1) <= 2:
        print(len(res1))
        for (a,b) in res1:
            print(a,b)
    else:
        print(len(res0))
        for (a,b) in res0:
            print(a,b)

