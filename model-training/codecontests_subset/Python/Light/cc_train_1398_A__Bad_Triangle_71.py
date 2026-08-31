t = int(input())
res = []
for _ in range(t):
    n = int(input())
    A = list(map(int, input().split()))
    if A[0] + A[1] <= A[-1]:
        res.append('{} {} {}'.format(1, 2, n))
    else:
        res.append('-1')

print('\n'.join(res))