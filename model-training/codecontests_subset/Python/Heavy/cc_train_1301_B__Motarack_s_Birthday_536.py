import sys
input = sys.stdin.readline


def main():
    t = int(input())
    for _ in range(t):
        N = int(input())
        A = [int(x) for x in input().split()]

        x = set()
        for a, b in zip(A, A[1:]):
            if a == -1 and b != -1:
                x.add(b)
            if b == -1 and a != -1:
                x.add(a)

        y = 0
        if len(x) == 0:
            print(0, 0)
            continue
        elif len(x) == 1:
            y = max(x)
        else:
            y = (max(x) + min(x)) // 2

        ma = -float("inf")
        for a, b in zip(A, A[1:]):
            if a == -1 and b != -1:
                ma = max(abs(b - y), ma)
            if b == -1 and a != -1:
                ma = max(abs(a - y), ma)
            if a != -1 and b != -1:
                ma = max(abs(a - b), ma)

        print(ma, y)


if __name__ == '__main__':
    main()


