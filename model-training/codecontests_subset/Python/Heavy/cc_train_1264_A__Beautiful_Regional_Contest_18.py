import sys
input = sys.stdin.readline
import collections
from operator import itemgetter



def main():
    t = int(input())
    for _ in range(t):
        N = int(input())
        P = [int(x) for x in input().split()]

        g = 0
        s = 0
        b = 0
        c = collections.Counter(P)
        for i in sorted(c.keys(), reverse=True):
            if g == 0:
                g = c[i]
            else:
                if s <= g:
                    s += c[i]
                else:
                    if (g + s + b + c[i]) > (N // 2):
                        break
                    b += c[i]

        if g < s and g < b:
            if g > 0 and b > 0 and s > 0:
                print(g, s, b)
            else:
                print("0 0 0")
        else:
            print("0 0 0")


if __name__ == '__main__':
    main()


