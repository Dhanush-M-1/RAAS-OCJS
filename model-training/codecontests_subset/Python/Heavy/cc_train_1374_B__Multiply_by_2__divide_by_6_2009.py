from sys import stdin


def main():
    input = lambda: stdin.readline()[:-1]
    T = int(input())
    for _ in [0] * T:
        N = int(input())

        if N == 1:
            print(0)
            continue

        ans = 1
        while 1:
            n = sum(map(int, list(str(N))))
            if n % 3:
                print(-1)
                break
            d, m = divmod(N, 6)
            if d == 1 and not m:
                print(ans)
                break
            elif not m:
                N = d
            else:
                N *= 2
            ans += 1


main()
