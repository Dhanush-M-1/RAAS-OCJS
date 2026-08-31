import sys

t = int(sys.stdin.readline().rstrip())

def main():
    for _ in range(t):
        n = int(sys.stdin.readline().rstrip())
        *a, = map(int, sys.stdin.readline().split())

        m = 0
        res = set()
        for i in range(n):
            cur = a[i]
            if cur == -1:
                if i > 0 and a[i-1] != -1:
                    res.add(a[i-1])
                if i < n - 1 and a[i+1] != -1:
                    res.add(a[i+1])
            else:
                if i > 0 and a[i-1] != -1:
                    m = max(m, abs(cur - a[i-1]))

        res = sorted(res)
        if not res:
            k = 0
        else:
            k = (res[0] + res[-1]) // 2
            m = max(res[-1] - k, m)
            
        yield m, k

if __name__ == '__main__':
    ans = main()
    for a in ans:
        print(*a, sep=' ')