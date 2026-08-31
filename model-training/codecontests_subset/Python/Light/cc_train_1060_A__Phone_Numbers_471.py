from collections import Counter

EIGHT = '8'

def solve(n, s):
    counts = Counter(s)
    r = 0

    while counts[EIGHT]:
        d = 10
        counts[EIGHT] -= 1
        for k, v in counts.items():
            if k != EIGHT:
                e = min(d, v)
                d -= e
                counts[k] -= e
        e = min(d, counts[EIGHT])
        d -= e
        counts[EIGHT] -= e
        if d > 0:
            break
        r += 1

    return r


n = int(input())
s = input()
print(solve(n, s))
