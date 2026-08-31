import math

def minInt(l, r, d):
    if d < l:
        return d
    elif r%d == 0:
        return r+d
    else:
        return math.ceil(r/d)*d


def main():
    n = int(input())
    res = []
    for _ in range(n):
        res.append(minInt(*list(map(int, input().split()))))
    for out in res:
        print(out)

if __name__ == '__main__':
    main()

