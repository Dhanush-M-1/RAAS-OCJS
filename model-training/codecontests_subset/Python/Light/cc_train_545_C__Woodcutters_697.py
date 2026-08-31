def solve():
    n = int(input())
    trees = [0 for _ in range(n)]
    height = [0 for _ in range(n)]
    for i in range(n):
        trees[i], height[i] = map(int, input().rstrip().split())
    felled = 0 
    for i in range(n):
        if i == 0:
            felled += 1
        elif i == n - 1:
            felled += 1
        elif trees[i - 1] + height[i] < trees[i]:
            felled += 1
        elif trees[i + 1] - height[i] > trees[i]:
            felled += 1
            trees[i] += height[i]
    print(felled)

if __name__ == '__main__':
    solve()
