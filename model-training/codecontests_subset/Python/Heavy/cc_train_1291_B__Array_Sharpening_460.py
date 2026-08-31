for _ in range (int(input())):
    n = int(input())
    l = list(map(int, input().split()))
    l1 = [0] * n
    l2 = [0] * n
    c = 0
    for i in range (n):
        l1[i] = min(i, n - i - 1)
    if n % 2 == 0:
        if l[(n // 2) - 1] > l[n // 2]:
            l1[(n // 2) - 1] += 1
        if l[(n // 2) - 1] <= l[n // 2]:
            l1[n // 2] += 1
    f = 0
    for i in range (n):
        if l1[i] > l[i]:
            f = 1
            break
    if f == 0:
        print("Yes")
    else:
        print("No")