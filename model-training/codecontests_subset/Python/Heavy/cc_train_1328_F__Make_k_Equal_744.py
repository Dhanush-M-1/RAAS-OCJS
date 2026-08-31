n, k = map(int, input().split())
res = k*20
a = list(map(int, input().split()))

ansNum = dict()
ansCost = dict()
ansCost.fromkeys(a, 0)
for i in a:
    ansNum[i] = ansNum.get(i, 0) + 1
    if ansNum[i] >= k:
        res = 0


l = n
c = 0
while True:
    ir = 0
    iw = 0
    c+=1
    if l <= 0:
        break

    while iw < l:
        if a[ir] == 0:
            l-=1
        else:
            a[iw] = a[ir]>>1
            ansNum[a[iw]] = ansNum.get(a[iw], 0)+1
            ansCost[a[iw]] = ansCost.get(a[iw], 0)+c
            if ansNum[a[iw]] == k:
                res = min(res, ansCost[a[iw]])
            iw+=1
        ir+=1

print(res)