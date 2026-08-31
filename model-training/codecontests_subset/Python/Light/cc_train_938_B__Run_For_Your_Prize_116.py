n = int(input())
ai = list(map(int, input().split()))

a1 = list(map(lambda x: x - 1,     list(filter(lambda x: x < 500001, ai))))
a2 = list(map(lambda x: 10**6 - x, list(filter(lambda x: x > 500000, ai))))

print(max(a1 + a2), end='')