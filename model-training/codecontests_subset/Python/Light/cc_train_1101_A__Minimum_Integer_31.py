from math import *

q = int(input())
print()
for i in range(q):
    s = input()
    left, r, d = s.split()  # split string input
    left = float(left)
    r = float(r)
    d = float(d)
    if (left / d) > 1 or (r / d) < 1:
        print(int(d))
    else:
        print(int(d * (floor(r / d) + 1)))
