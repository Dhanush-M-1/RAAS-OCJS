n = int(input())
A = list(map(int, input().split()))


def max_subarray(A):
    max_ending_here = max_so_far = 0
    for x in A:
        max_ending_here = max(0, max_ending_here + x)
        max_so_far = max(max_so_far, max_ending_here)
    return max_so_far


def f1(x):
    return max_subarray(a-x for a in A)


def f2(x):
    return max_subarray(-a+x for a in A)


m = max(abs(a) for a in A)
l, r = -m, m

for _ in range(100):
    mid = (l+r) / 2
    v1, v2 = f1(mid), f2(mid)
    if abs(v1 - v2) < 1e-8:
        break
    elif v1 > v2:
        l = mid
    else:
        r = mid

print(v1)
