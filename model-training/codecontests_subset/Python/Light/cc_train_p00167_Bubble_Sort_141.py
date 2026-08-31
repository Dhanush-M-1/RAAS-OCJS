while True:
    N = int(input())
    if N == 0:
        break

    a = []
    cnt = 0
    for l in range(N):
        a.append(int(input()))
    for i in range(N-1, 0, -1):
        for j in range(i):
            if a[j] > a[j+1]:
                a[j], a[j+1] = a[j+1], a[j]
                cnt += 1

    print(cnt)

