import sys

input = sys.stdin.readline


def main():
    t = int(input())
    for _ in range(t):
        N, M = [int(x) for x in input().split()]
        S = input().strip()
        P = [int(x) for x in input().split()]

        A = [[0] * 26 for j in range(N + 1)]

        for i in range(1, N + 1):
            for j in range(26):
                A[i][j] = A[i - 1][j]
            A[i][ord(S[i - 1]) - ord('a')] += 1
        ans = [0] * 26
        for p in P:
            for j in range(26):
                ans[j] += A[p][j]

        for j in range(26):
            ans[j] += A[N][j]
        print(*ans)


if __name__ == '__main__':
    main()
