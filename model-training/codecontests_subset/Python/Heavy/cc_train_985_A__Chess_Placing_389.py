def f(filled, empty):
    filled.sort()
    empty.sort()
    c = 0
    for i in range(len(filled)):
        c += abs(empty[i] - filled[i])
    return c


n = int(input())
filled_w = []
empty_b = []
filled_b = []
empty_w = []
numbers = []
for i in range(1, n + 1):
    numbers.append(i)
for item in input().split():
    item = int(item)
    if item % 2 == 0:
        filled_w.append(item)
    else:
        filled_b.append(item)
    numbers.remove(item)
for item in numbers:
    if item % 2 == 0:
        empty_w.append(item)
    else:
        empty_b.append(item)
print(min(f(filled_w, empty_b), f(filled_b, empty_w)))