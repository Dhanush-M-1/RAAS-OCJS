import sys
def fmax(o,p,n):
    if not o:
        p.sort()
        return sum(p[:n])
    elif not p:
        o.sort()
        return sum(o[:n])
    o.sort()
    p.sort()
    if len(o) < len(p):
        return sum(p[:n])
    else:
        return sum(o[:n])
def solve(a):
    o = []
    p = []
    for n in a:
        if n%2 == 0:
            p.append(n)
        else:
            o.append(n)
    if abs(len(p)-len(o)) == 0 or abs(len(p)-len(o)) == 1:
        return 0
    else:
        return fmax(o,p,abs(len(p)-len(o))-1)
n = int(sys.stdin.readline().strip())
a = list(map(int,sys.stdin.readline().strip().split()))
res = solve(a)
sys.stdout.write(str(res)+'\n')