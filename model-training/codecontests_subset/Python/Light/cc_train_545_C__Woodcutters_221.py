def solve(n, x, h):
    out = min(n, 2)
    endpt = x[0]
    for i in range(1, n-1):
        if max(x[i-1], endpt) < x[i] - h[i]:
            out += 1
            endpt = x[i]
        elif x[i] + h[i] < x[i+1]:
            out += 1
            endpt = x[i] + h[i]
    return out

if __name__ == "__main__":
    n = int(input())
    x = []; h = []
    for i in range(n):
        xi, hi = map(int, input().split())
        x.append(xi)
        h.append(hi)
    print(solve(n, x, h))
