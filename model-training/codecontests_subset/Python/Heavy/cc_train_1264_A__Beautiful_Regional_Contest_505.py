x = int(input())
W = []
for j in range(x):
    a = int(input())
    A = list(map(int, input().split()))
    B = [[A[0], 1]]
    for i in range(1, a):
        if A[i] == A[i - 1]:
            B[-1][1] += 1
        else:
            B.append([A[i], 1])
    qwer = 0
    for i in range(len(B)):
        qwer += B[i][1]
    qwe = 0
    i = 0
    while qwe + B[i][1] <= qwer // 2:
        qwe += B[i][1]
        i += 1
    ANS = [0, 0, 0]
    if i >= 3:
        if qwe > B[0][1] * 3:
            qwed = 0
            i = 1
            while qwed <= B[0][1]:
                qwed += B[i][1]
                i += 1
            if B[0][1] < qwe - B[0][1] - qwed:
                ANS = [B[0][1], qwed, qwe - B[0][1] - qwed]
    W.append(ANS)

for a in W:
    print(*a)