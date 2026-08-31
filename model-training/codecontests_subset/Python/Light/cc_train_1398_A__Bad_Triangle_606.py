from sys import stdin


def main():
    input = lambda: stdin.readline()[:-1]
    T = int(input())
    for _ in [0] * T:
        N = int(input())
        A = list(map(int, input().split()))

        if A[0] + A[1] <= A[-1]:
            print(1, 2, N)
        else:
            print(-1)


main()
