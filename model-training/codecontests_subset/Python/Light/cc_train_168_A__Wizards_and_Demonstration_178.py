j, m, p = map(int, input().split())
l = j * p
l = l // 100 + int(l % 100 > 0) - m
print(max(l, 0))
