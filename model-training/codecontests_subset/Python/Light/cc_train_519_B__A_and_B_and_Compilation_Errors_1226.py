n = int(input())
mas1 = list(map(int, input().split()))
mas2 = list(map(int, input().split()))
mas3 = list(map(int, input().split()))
mas1 = sorted(mas1)
mas2 = sorted(mas2)
mas3 = sorted(mas3)
i = 0
while i < n - 1:
    if mas1[i] != mas2[i]:
        a = mas1[i]
        break
    i += 1
if i == n - 1:
    a = mas1[i]
i = 0
while i < n - 2:
    if mas2[i] != mas3[i]:
        b = mas2[i]
        break
    i += 1
if i == n - 2:
    b = mas2[i]
print(a)
print(b)
