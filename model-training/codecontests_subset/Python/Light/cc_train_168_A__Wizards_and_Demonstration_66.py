from math import ceil

n, x, y = map(int, input().split())
wizard_needed = ceil((n * y) / 100)

print(max(0, wizard_needed - x))