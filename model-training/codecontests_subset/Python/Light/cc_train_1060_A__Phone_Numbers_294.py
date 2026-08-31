n = int(input())
a = [int(x) for x in input().strip()]
c8 = a.count(8)
print(min([c8, n // 11]))
