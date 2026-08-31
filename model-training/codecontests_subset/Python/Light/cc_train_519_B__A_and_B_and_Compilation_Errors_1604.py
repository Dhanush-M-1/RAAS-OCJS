n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))
suma, sumb, sumc = 0, 0, 0
for i in range(n):
    suma += a[i]
for i in range(n - 1):
    sumb += b[i]
for i in range(n - 2):
    sumc += c[i]
print(suma - sumb)
print(sumb - sumc)
