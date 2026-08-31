def main():
    import sys
    input = sys.stdin.readline

    T = int(input())
    for t in range(T):
        n = int(input())
        a = list(map(int, input().split()))
        b = []
        for i in range(n):
            if a[i] == -1:
                if i-1 >= 0 and a[i-1] != -1:
                    b.append(a[i-1])
                if i+1 < n and a[i+1] != -1:
                    b.append(a[i+1])
        if len(b) == 0:
            print(0, 0)
            continue
        mn, mx = min(b), max(b)
        k = (mn + mx) // 2
        m = 0
        for i in range(n):
            if a[i] == -1:
                a[i] = k
            if i > 0:
                d = abs(a[i] - a[i-1])
                m = max(m, d)
        print(m, k)

main()