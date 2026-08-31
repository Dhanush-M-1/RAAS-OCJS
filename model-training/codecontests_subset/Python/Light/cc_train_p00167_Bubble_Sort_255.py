while True:
    n = int(input())
    if n == 0:
        break
    L=[]
    for _ in range(n):
        L.append(int(input()))

    cnt = 0
    for k in range(1,len(L))[::-1]:
        for i in range(k):
            if L[i+1] < L[i]:
                cnt += 1
                L[i+1], L[i] = L[i], L[i+1]
    print(cnt)


