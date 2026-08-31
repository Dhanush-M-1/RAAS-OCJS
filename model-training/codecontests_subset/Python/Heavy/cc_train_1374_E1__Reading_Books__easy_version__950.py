n, k = list(map(int, input().split()))
time, A, B, AB, lenA, lenB, lenAB = [], [], [], [], 0, 0, 0
for idx in range(n):
    t, a, b = list(map(int, input().split()))
    time.append(t)
    if a and not b:
        A.append(t)
        lenA += 1
    elif b and not a:
        B.append(t)
        lenB += 1
    elif a and b:
        AB.append(t)
        lenAB += 1
if lenA+lenAB<k or lenB+lenAB<k:
    print(-1)
else:
    A.sort()
    B.sort()
    AB.sort()
    s, x, y = 0, 0, 0
    for i in range(k):
        if x<lenA and x<lenB and y<lenAB:
            if A[x]+B[x]<AB[y]:
                s += A[x]+B[x]
                x += 1
            else:
                s += AB[y]
                y += 1
        elif x>=lenA or x>=lenB:
            s += AB[y]
            y += 1
        elif y>=lenAB and x<lenA and x<lenB:
            s += A[x]+B[x]
            x += 1
    print(s)