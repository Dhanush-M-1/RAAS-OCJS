s = input()
[n, k] = list(map(int, s.split()))
max_n = -1

t = input()
for _ in range(n):
    numbers = map(int, t.split())
    for a in numbers:
        if k % a == 0 and a > max_n:
            max_n = a
print(k // max_n)