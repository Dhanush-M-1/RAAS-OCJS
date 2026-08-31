from sys import stdin


def main():
    input = lambda: stdin.readline()[:-1]
    T = int(input())
    ABC = [tuple(map(int, input().split())) for _ in [0] * T]

    for a, b, c in ABC:
        divb, modb = divmod(b, 2)
        case1 = min(a, divb)
        divc, modc = divmod(c, 2)
        case1 += min(modb, divc)

        divc, modc = divmod(c, 2)
        case2 = min(b, divc)
        divb, modb = divmod(b - case2, 2)
        case2 += min(a, divb)

        print(max(case1 * 3, case2 * 3))


main()
