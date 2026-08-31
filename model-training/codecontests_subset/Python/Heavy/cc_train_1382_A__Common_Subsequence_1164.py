#
# Smallest common subsequence (i.e. single same element if it exists)
#

def solve(ls1, ls2):
    ls = set(ls1).intersection(set(ls2))
    return list(ls)[0] if len(ls) > 0 else None


def main(istr, ostr):
    t = int(istr.readline())
    for _ in range(t):
        n, m = list(map(int, istr.readline().split()))
        ls1 = list(map(int, istr.readline().split()))
        ls2 = list(map(int, istr.readline().split()))
        result = solve(ls1, ls2)
        if result:
            print('YES', file=ostr)
            print(1, result, file=ostr)
        else:
            print('NO')


if __name__ == "__main__":
    import sys

    main(sys.stdin, sys.stdout)
