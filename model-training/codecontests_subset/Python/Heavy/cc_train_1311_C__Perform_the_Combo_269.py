import string, sys


def bin_search(i, mas):
    left = -1
    right = len(mas)
    while right - left > 1:
        mid = (right + left) // 2
        if mas[mid] > i:
            right = mid
        else:
            left = mid
    return right


t = int(input())
for _ in range(t):
    num = dict((string.ascii_lowercase[i], 0) for i in range(26))
    n, m = map(int, sys.stdin.readline().split())
    a = str(sys.stdin.readline())
    p = [int(i) for i in sys.stdin.readline().split()]
    p.sort()
    for i in range(n):
        num[a[i]] += (m - bin_search(i, p) + 1)
    for i in string.ascii_lowercase:
        sys.stdout.write(str(num[i]) + ' ')
    sys.stdout.write('\n')