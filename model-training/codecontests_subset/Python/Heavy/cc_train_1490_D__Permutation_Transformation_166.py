import sys

input = sys.stdin.readline


def main():
    t = int(input())
    for _ in range(t):
        N = int(input())
        A = [int(x) for x in input().split()]

        ans = [-1] * N

        def solve(l, r, depth):
            if l == r:
                ans[l] = depth
                return

            ma = 0
            mai = 0
            for i in range(l, r + 1):
                if A[i] > ma:
                    mai = i
                    ma = A[i]

            ans[mai] = depth
            if l != mai:
                solve(l, mai - 1, depth + 1)
            if r != mai:
                solve(mai + 1, r, depth + 1)

        solve(0, N - 1, 0)
        print(*ans)


if __name__ == '__main__':
    main()
