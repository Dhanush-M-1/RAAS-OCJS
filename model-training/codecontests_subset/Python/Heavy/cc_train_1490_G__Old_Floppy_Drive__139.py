import bisect

def main():
    t = int(input())
    for _ in range(t):
        n, m = map(int, input().split())
        a = list(map(int, input().split()))
        x = list(map(int, input().split()))
        p = []
        pts = []; M = 0; d = {}; suma = 0
        for i in range(n):
            suma += a[i]
            if suma > M:
                M = suma
                pts.append(M)
                d[M] = i
        for i in range(m):
            xi = x[i]
            if not pts:
                p.append(-1); continue
            if suma <= 0 or xi <= pts[-1]:
                if xi > pts[-1]:
                    p.append(-1); continue
                else:
                    idx = bisect.bisect_left(pts, xi)
                    p.append(d[pts[idx]])
            else:
                laps = (xi - pts[-1]) // suma
                if (xi - pts[-1]) % suma:
                    laps += 1
                xi -= laps * suma
                idx = bisect.bisect_left(pts, xi)
                p.append(d[pts[idx]] + n * laps)
        print(*p)
main()