# -*- coding: utf-8 -*-

t = int(input())

for i in range(t):
    n = int(input())
    A = [int(i) for i in input().split()]

    a0 = A[0]
    d = []
    for j in range(1, n):
        a1 = A[j]
        d.append(a1 - a0)
        a0 = a1

    fl = True
    res = True

    if n == 1:
        fl = False
    elif n == 2:
        fl = False
        if A[0] == 0 and A[1] == 0:
            res = False

    ind = 0
    v = True
    while fl:
        d0 = d[ind]

        if v:
            if d0 <= 0:
                if A[ind + 1] < ind + 1:
                    v = False
                    if A[ind] < n - ind - 1:
                        fl = False
                        res = False

        else:
            if d0 >= 0:
                if A[ind] < n - ind - 1:
                    fl = False
                    res = False

        ind += 1
        if ind >= n-1:
            fl = False

    if res:
        print('Yes')
    else:
        print('No')