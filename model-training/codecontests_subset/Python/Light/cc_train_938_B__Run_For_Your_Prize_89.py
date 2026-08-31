n = int(input())
l = list(map(int, input().split()))
x, y = list(filter(lambda x: x <= 500000, l)), list(filter(lambda x: x > 500000, l))
s = 0
if len(x) > 0:
    s = x[-1] - 1
if len(y) > 0:
    s = max(s, 1000000 - y[0])

print(s)




