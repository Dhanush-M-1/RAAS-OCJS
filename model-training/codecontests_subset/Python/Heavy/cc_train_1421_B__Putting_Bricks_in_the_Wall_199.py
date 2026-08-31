from sys import stdin


def main():
    input = lambda: stdin.readline()[:-1]
    T = int(input())
    for _ in [0] * T:
        N = int(input())
        S = [input() for _ in [0] * N]

        sd, sr = int(S[1][0]), int(S[0][1])
        fu, fl = int(S[N - 2][N - 1]), int(S[N - 1][N - 2])
        if sd + sr + fu + fl == 0 or sd + sr + fu + fl == 4:
            ans1 = 2
            ans2 = [(1, 2), (2, 1)]
        elif sd == sr and fu == fl:
            ans1 = 0
            ans2 = []
        elif sd == sr:
            ans1 = 1
            if fu == sd:
                ans2 = [(N - 1, N)]
            else:
                ans2 = [(N, N - 1)]
        elif fu == fl:
            ans1 = 1
            if sd == fu:
                ans2 = [(2, 1)]
            else:
                ans2 = [(1, 2)]
        else:
            ans1 = 2
            ans2 = []
            if sd:
                ans2.append((2, 1))
            if sr:
                ans2.append((1, 2))
            if not fu:
                ans2.append((N - 1, N))
            if not fl:
                ans2.append((N, N - 1))

        print(ans1)
        for a in ans2:
            print(*a)


main()
