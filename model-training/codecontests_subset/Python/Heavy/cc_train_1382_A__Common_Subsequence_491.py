import sys


def smallest_subsequence(a, b):
    b_set = set(b)

    for i in a:
        if i in b_set:
            return i

    return None


def main(fd=sys.stdin):
    t = int(next(fd))

    for _ in range(t):
        next(fd)
        a = [int(i) for i in next(fd).split()]
        b = [int(i) for i in next(fd).split()]

        c = smallest_subsequence(a, b)

        if c is None:
            print("NO")
        else:
            print("YES")
            print(f"1 {c}")


if __name__ == "__main__":
    main()
