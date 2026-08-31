# int(input())
# [int(s) for s in input().split()]
# input()


def solve():
    q = int(input())

    for i in range(q):
        l, r, d = [int(s) for s in input().split()]

        if d < l:
            print(d)
        else:
            print(r+(d-r%d))


if __name__ == "__main__":
    solve()