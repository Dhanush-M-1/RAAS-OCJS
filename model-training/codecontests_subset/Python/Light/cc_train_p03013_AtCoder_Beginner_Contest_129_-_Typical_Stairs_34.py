n,m = map(int,input().split())
D=[1] * (n+1)
for _ in range(m):
    D[int(input())] = 0
for i in range(2, n+1):
    D[i] = (D[i-1] + D[i-2]) % 1000000007 * D[i]
print(D[n])