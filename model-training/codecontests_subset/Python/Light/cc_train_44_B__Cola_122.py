n, a, b, c = map(int, input().split())
print(sum(n - i // 2 - 2 * j in range(0, b + 1) for i in range(0, a + 1, 2) for j in range(c + 1)))