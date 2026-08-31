div = 10 ** 9 + 7
N, M = map(int, input().split())
h = [1] * (N + 1)
for _ in range(M):
    index = int(input())
    h[index] = 0

a = 1
b = h[1]
for i in range(2, N + 1):
    a, b = b, (a + b) * h[i] % div

print(b)
