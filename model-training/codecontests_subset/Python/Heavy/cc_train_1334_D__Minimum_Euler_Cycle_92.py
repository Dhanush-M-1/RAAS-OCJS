import sys;input=sys.stdin.readline
t, = map(int, input().split())

def gen(k):
    return [k+(i+1)//2 if i%2 else k for i in range(2*(n-k))]

for _ in range(t):
    n, s, e = map(int, input().split())
    k, sm = 0, 0
    while sm < s and k < n-1:
        k += 1
        sm += 2*(n-k)
    if sm < s:
        k+=1

    k2, sm2 = 0, 0
    while sm2 < e and k2 < n-1:
        k2 += 1
        sm2 += 2*(n-k2)
    if sm2 < e:
        k2+=1
    if k == n:
        print(1)
    elif k == k2:
        L = gen(k)
        tt, tt2 = sm-2*(n-k), sm2-2*(n-k2)
        print(*L[s-tt-1:e-tt2])
    else:
        tt, tt2 = sm-2*(n-k), sm2-2*(n-k2)
        L = gen(k)[s-tt-1:]
        L2 = gen(k2)[:e-tt2]
        for l in range(k+1, k2):
            L += gen(l)
        L += L2
        if k2 == n:
            L.append(1)
        print(*L)
