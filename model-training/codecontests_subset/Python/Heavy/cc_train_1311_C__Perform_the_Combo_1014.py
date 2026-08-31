ax = ord('a')
ttt = int(input())
while ttt:
    ttt -= 1
    nm = [int(i) for  i in input().split()]
    a = input()
    p = [int(i) for  i in input().split()]
    x = [0] * 26
    lk = []
    for i in range(len(x)): lk.append([0] * len(a))
    for c in range(len(lk)):
        t = chr(c + ax)
        lkc = lk[c]
        if t == a[0]: lkc[0] = 1
        for i in range(1, len(lkc)):
            lkc[i] = lkc[i - 1] + 1 if a[i] == t else lkc[i - 1]

    for v in p:
        for j in range(len(lk)): x[j] += lk[j][v - 1]
    for i in range(len(x)): x[i] += lk[i][-1]
    print(' '.join([str(i) for i in x]))
