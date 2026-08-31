n = int(input())
a = list(input())
a = [int(x) for x in a]
print(min(a.count(8), n // 11))
