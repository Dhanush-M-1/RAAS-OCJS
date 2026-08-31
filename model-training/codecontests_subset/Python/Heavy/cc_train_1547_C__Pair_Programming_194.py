def solution(k, a, b):
    n = len(a)
    m = len(b)

    i, j = 0, 0
    result = []
    for _ in range(m + n):
        if i < n and (a[i] <= k or a[i] == 0):
            if a[i] == 0:
                k += 1
            result.append(a[i])
            i += 1
        elif j < m and (b[j] <= k or b[j] == 0):
            if b[j] == 0:
                k += 1
            result.append(b[j])
            j += 1
        else:
            return [-1]
    return result


for _ in range(int(input())):
    _ = input()
    k, n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    print(' '.join(str(x) for x in solution(k,a,b)))
