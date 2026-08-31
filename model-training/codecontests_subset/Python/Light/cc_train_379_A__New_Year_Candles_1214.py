import sys

a, b = [int(i) for i in sys.stdin.readline().rstrip().split()]
hours = 0
went_out = 0

while a > 0:
    went_out += 1
    if went_out >= b:
        went_out -= b
        a += 1
    a -= 1
    hours += 1
print(hours)