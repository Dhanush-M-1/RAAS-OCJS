n = int(input())
a = list(map(int, input().rstrip().split()))

attuale = 0
for i in range(n):
    ma = min(a[i] - 1, 1000000 - a[i])
    attuale = max(ma, attuale)
print(attuale)