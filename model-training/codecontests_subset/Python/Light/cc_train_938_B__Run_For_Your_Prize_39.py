p1 = 1
p2 = 10 ** 6



n = int(input())
a = [int(x) for x in input().split()]
m = 0
for i in a:
    m = max(min([p2 - i, i - p1]), m)

print(m)
