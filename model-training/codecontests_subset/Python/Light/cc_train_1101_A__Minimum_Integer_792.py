
q = int(input())


def solve(l,r,d):
    if l > d:
        return d
    else:
        if r%d == 0:
            return r+d
        else:
            return d*(r//d+1)

for _ in range(q):
    [l,r,d] = list(map(int, input().split()))
    print(solve(l,r,d))
