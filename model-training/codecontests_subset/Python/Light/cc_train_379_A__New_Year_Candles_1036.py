# A. Новогодние свечки
n, m = map(int, input().split())
i = 1
while n >= m * i:
    n += 1
    i += 1
print(n)