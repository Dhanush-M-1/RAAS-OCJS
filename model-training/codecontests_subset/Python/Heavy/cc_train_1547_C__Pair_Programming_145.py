t = int(input())


def read_ints():
    return list(map(int, input().split()))


def get_order(k, a, b):
    n, m = len(a), len(b)
    order = []
    i, j = 0, 0
    while i < n or j < m:
        if i < n and a[i] == 0:
            order.append(0)
            k += 1
            i += 1
        elif j < m and b[j] == 0:
            order.append(0)
            k += 1
            j += 1
        elif i < n and (j == m or a[i] <= b[j]):
            if a[i] <= k:
                order.append(a[i])
                i += 1
            else:
                return [-1]
        elif j < m and (i == n or a[i] > b[j]):
            if b[j] <= k:
                order.append(b[j])
                j += 1
            else:
                return [-1]
        else:
            return [-1]
    return order


for _ in range(t):
    input()
    k, _, _ = read_ints()
    a, b = read_ints(), read_ints()
    print(' '.join(map(str, get_order(k, a, b))))


