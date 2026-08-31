def check(n, m, c, d):
    lst = list()
    for i in range(n):
        result, flag = -1, True
        for j in range(0, n):
            cur = (d[(i + j) % n] - c[j]) % m
            if result == -1:
                result = cur
            elif result != cur:
                flag = False
                break
        if flag:
            lst.append(result)
    return min(lst)


n, m = [int(i) for i in input().split()]
c = [int(i) for i in input().split()]
d = [int(i) for i in input().split()]
print(check(n, m, sorted(c), sorted(d)))