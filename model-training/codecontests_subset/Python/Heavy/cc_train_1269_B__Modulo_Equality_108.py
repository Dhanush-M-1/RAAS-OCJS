import sys
from collections import Counter

# inf = open('input.txt', 'r')
# reader = (map(int, line.split()) for line in inf)
reader = (map(int, line.split()) for line in sys.stdin)
input = reader.__next__


n, m = input()
a = list(input())
b = list(input())
def add_equal(a, b, n, m):
    check = Counter(b)
    compare = Counter(a)
    if check == compare:
        return 0
    
    x_cand = set((b[0] - ai) % m for ai in a)
    for x in sorted(x_cand):
        check_curr = check.copy()
        for ai in a:
            bj = (ai + x) % m
            check_curr[bj] -= 1
            if check_curr[bj] == 0:
                check_curr.pop(bj)
        if not check_curr:
            return x
ans = add_equal(a, b, n, m)
print(ans)

# inf.close()
