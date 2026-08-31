import sys

n = sys.stdin.readline()
prizes = map(int, sys.stdin.readline().strip().split())
max_steps = 0
max_steps2 = 0
pos2 = int(10 ** 6)
border = int(pos2 / 2)
for i in prizes:
    if i <= border:
        max_steps = max(max_steps, i - 1)
    else:
        max_steps2 = max(max_steps2, pos2 - i)
print(max(max_steps, max_steps2))