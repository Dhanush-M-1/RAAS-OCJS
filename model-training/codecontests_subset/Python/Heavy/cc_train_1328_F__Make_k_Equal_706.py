import sys

class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

        self.cnt


def main():
    # q = int(sys.stdin.readline().strip())
        # k = int(sys.stdin.readline().strip())
    n, m = [int(s) for s in sys.stdin.readline().strip().split()]
    xs = sorted(int(s) for s in sys.stdin.readline().strip().split())
    mmm = max(xs) + 1

    prefix = [0 for _ in range(mmm)]
    costs = [0 for _ in range(mmm)]
    for x in xs:
        c = 0
        while x > 0:
            if prefix[x] < m:
                costs[x] += c
            prefix[x] += 1
            c += 1
            x //= 2
        if prefix[0] < m:
            costs[0] += c
        prefix[0] += 1

    best = None
    for i in range(mmm):
        if prefix[i] >= m:
            s = costs[i]
            if best is None:
                best = s
            else:
                best = min(best, s)

    print(best)

main()
