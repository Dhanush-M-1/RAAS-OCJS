k, n = map(int, input().split())
m = list(map(int, input().split()))
m.sort(reverse = 1)
for i in range(k):
    if n % m[i] == 0:
        print(n // m[i])
        break