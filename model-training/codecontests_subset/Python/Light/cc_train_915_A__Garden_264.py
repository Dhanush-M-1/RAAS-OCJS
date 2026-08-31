n,k = map(int, input().split())
s = reversed(sorted([int(a) for a in input().split()]))

def solve(k, s):
    for a in s:
        if k % a == 0:
            return k // a

print(solve(k, s))

