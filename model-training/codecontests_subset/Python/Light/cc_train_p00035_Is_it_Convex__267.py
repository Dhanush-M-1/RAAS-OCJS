import sys
readlines = sys.stdin.readlines
write = sys.stdout.write
def cross3(a, b, c):
    return (b[0]-a[0])*(c[1]-a[1]) - (b[1]-a[1])*(c[0]-a[0])
def solve():
    for line in readlines():
        xa, ya, xb, yb, xc, yc, xd, yd = map(float, line.split(","))
        P = [(xa, ya), (xb, yb), (xc, yc), (xd, yd)]
        D = []
        for i in range(4):
            p0 = P[i-2]; p1 = P[i-1]; p2 = P[i]
            D.append(cross3(p0, p1, p2))
        if all(e > 0 for e in D) or all(e < 0 for e in D):
            write("YES\n")
        else:
            write("NO\n")
solve()

