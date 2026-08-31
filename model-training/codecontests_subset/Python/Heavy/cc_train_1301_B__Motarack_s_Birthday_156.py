from sys import stdin, stdout

def maxDiff(a, k):
    t = [v if v != -1 else k for v in a]
    ret = 0
    for i in range(len(t) - 1):
        ret = max(ret, abs(t[i] - t[i + 1]))
    return ret

for _ in range(int(stdin.readline())):
    n = int(stdin.readline())
    a = list(map(int, stdin.readline().split()))
    mn, mx = float('inf'), -float('inf')
    for i, v in enumerate(a):
        if a[i] != -1 and ((i - 1 >= 0 and a[i - 1] == -1) or (i + 1 < n and a[i + 1] == -1)):
            mn, mx = min(mn, v), max(mx, v)
    if mn == float('inf'):
        stdout.write('0 0\n')
    else:
        ret = (mn + mx) >> 1
        stdout.write('%d %d\n' % (maxDiff(a, ret), ret))