import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    p1, p2 = input().split()
    n = int(input())
    print(p1, p2)

    for i in range(n):
        s1, s2 = input().split()
        if s1 == p1:
            p1 = s2
        else:
            p2 = s2
        print(p1, p2)

if __name__ == '__main__':
    solve()