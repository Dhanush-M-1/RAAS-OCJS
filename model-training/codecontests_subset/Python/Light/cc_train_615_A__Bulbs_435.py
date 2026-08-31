b = [0 for i in range(107)]

n, m = map(int, input().split())
for _ in range(n):
    cnt, *bulbs = map(int, input().split())
    for bulb in bulbs:
        b[bulb] = 1

# print(b)
print(["NO", "YES"][sum(b[1:m + 1]) == m])
