t = int(input())


def read_ints():
    return list(map(int, input().split()))


def do_step(arr, i, k, order):
    order.append(arr[i])
    if arr[i] == 0:
        return True, i + 1, k + 1
    if arr[i] <= k:
        return True, i + 1, k
    else:
        return False, -1, -1


def get_order(k, a, b):
    n, m = len(a), len(b)
    order = []
    i, j = 0, 0
    while i != n or j != m:
        if i == n or (j != m and a[i] > b[j]):
            ok, j, k = do_step(b, j, k, order)
        else:
            ok, i, k = do_step(a, i, k, order)
        if not ok:
            return [-1]
    return order


for _ in range(t):
    input()
    k, _, _ = read_ints()
    a, b = read_ints(), read_ints()
    print(' '.join(map(str, get_order(k, a, b))))


