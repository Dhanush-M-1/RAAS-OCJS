import collections
import sys

def read_a_integer():
    return int(sys.stdin.readline())

def read_a_list(dtype):
    return list(map(dtype, sys.stdin.readline().split()))

def main():
    r1, r2 = read_a_list(int)
    c1, c2 = read_a_list(int)
    d1, d2 = read_a_list(int)

    if (r1 - c1 + d2) % 2:
        print("-1")
        return
    b = (r1 - c1 + d2) // 2
    if (d2 - r1 + c1) % 2:
        print("-1")
        return
    c = (d2 - r1 + c1) // 2
    d = r2 - c
    a = r1 - b
    if all(1 <= x <= 9 for x in [a, b, c, d]) \
        and len(set([a, b, c, d])) == 4 \
            and b + d == c2 and a + d == d1:
        print("{} {}\n{} {}".format(a, b, c, d))
    else:
        print("-1")

if __name__ == "__main__":
    main()
