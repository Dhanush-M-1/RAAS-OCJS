import pdb

def solve(n, trees):
    if n == 1:
        return 1
    dp = [[None for _ in range(3)] for _ in range(n-1)]
    for i, (x, h) in enumerate(trees[:n-1]):
        if i == 0:
            dp[i][0] = 0
            dp[i][1] = 1 if x+h < trees[i+1][0] else -float('inf')
            dp[i][2] = 1
        else:
            mx = max(dp[i-1][0], dp[i-1][1], dp[i-1][2])
            dp[i][0] = mx
            dp[i][1] = 1 + mx if x + h < trees[i+1][0] else -float('inf')
            lst = [-float('inf')]
            if trees[i-1][0] + trees[i-1][1] < x - h:
                lst.append(dp[i-1][1])
            if trees[i-1][0] < x - h:
                lst.append(dp[i-1][0])
                lst.append(dp[i-1][2])
            dp[i][2] = 1 + max(lst)
    return max(dp[n-2][0], dp[n-2][1], dp[n-2][2]) + 1

def main():
    n = int(input())
    trees = []
    for i in range(n):
        x, h = map(int, input().split())
        trees.append((x, h))
    sol = solve(n, trees)
    print(sol)

if __name__ == '__main__':
    main()
