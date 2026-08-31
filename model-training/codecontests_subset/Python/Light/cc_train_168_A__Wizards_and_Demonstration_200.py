import itertools as it

n, x, y = map(int, input().split())

for i in it.count():
    if (x + i) * 100 >= y * n:
        print(i)
        break
