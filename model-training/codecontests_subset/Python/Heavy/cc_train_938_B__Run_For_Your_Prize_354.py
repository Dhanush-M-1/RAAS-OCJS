from sys import stdin

lines = [l.strip() for l in stdin.readlines()]

all_prizes = sorted([int(p) for p in lines[1].split()])

left_sums = [0] * (len(all_prizes) + 1)
left_sums[0] = 0
last_position = 1
for i, p in enumerate(all_prizes):
    left_sums[i + 1] = left_sums[i] + p - last_position
    last_position = p

right_sums = [0] * (len(all_prizes) + 1)
right_sums[0] = 0
last_position = int(1E6)
for i, p in enumerate(all_prizes[::-1]):
    right_sums[i + 1] = right_sums[i] + last_position - p
    last_position = p

best = int(1E6)
for i in range(len(all_prizes) + 1):
    current = max(left_sums[i], right_sums[len(all_prizes) - i])
    best = min(best, current)

print(best)
