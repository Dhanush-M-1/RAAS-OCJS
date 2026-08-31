n, m = map(int, input().split())
w = [1 for _ in range(n+1)]
for _ in range(m):
    w[int(input())] = 0
for i in range(2, n+1):
    if w[i] != 0:
        w[i] = w[i-2] + w[i-1]
#print(w)
print(w[-1] % 1000000007)