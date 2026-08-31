n, k = [int(i) for i in input().split()]
lst = [int(i) for i in input().split()]


def hard(n, k, lst):
    a, result = [[] for i in range(1 + 2 * (10 ** 5))], 0
    for i in range(n):
        x, l = lst[i], 0
        while True:
            a[x].append(l)
            if x == 0:
                break
            x //= 2
            l += 1
    maximum = 1000000000
    for i in range(len(a)):
        a[i].sort()
        if len(a[i]) >= k:
            maximum = min(maximum, sum(a[i][:k]))
    return maximum


print(hard(n, k, lst))
