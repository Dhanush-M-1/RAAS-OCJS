a = int(input())
for i in range(a):
    n = int(input())
    a = list(map(int, input().split()))
    res = []
    i = 0
    j = 1
    k = 2
    while k < len(a) and a[i] + a[j] > a[k]:
        k += 1
    if k == len(a):
        print(-1)
    else:
        print(i + 1, j + 1, k + 1)
