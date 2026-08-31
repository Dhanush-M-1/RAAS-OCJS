def solve(A):
    a = A[:]
    incr = True
    a[0] = 0
    for i in range(1, len(a)):
        if incr:
            a[i] = min(a[i], a[i - 1] + 1)
            if a[i] <= a[i - 1]:
                incr = False
        if not incr:
            a[i] = max(min(a[i], a[i - 1] - 1), 0)
            if a[i] >= a[i - 1]:
                return False
    return True

t = int(input())
for i in range(t):
    n = input()
    a = list(map(int, input().split()))
    print("Yes" if (solve(a) or solve(a[::-1])) else "No")
