def input_int_list():
    return list(map(int, input().split(" ")))

n, m = map(int, input().split(" "))
a = input_int_list()
b = input_int_list()

a.sort()
b.sort()
from collections import deque
a = deque(a)

solved = False
total_offsets = 0
while True:
    diff = b[0] - a[0]
    solved = True
    for i in range(1, n):
        if diff < 0 or (b[i] - a[i]) != diff:
            offset = m - a[-1]
            total_offsets += offset
            for j in range(n):
                a[j] += offset
            while a[-1] == m:
                a.pop()
                a.appendleft(0)
            solved = False
            break
    if solved:
        break

print(total_offsets + (diff + m) % m)

