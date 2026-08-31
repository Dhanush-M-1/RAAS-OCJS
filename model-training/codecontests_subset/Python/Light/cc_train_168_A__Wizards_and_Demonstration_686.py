import math
string = input()
n, x, y = map(int, string.split())
a = math.ceil(y / 100 * n)
if a < x:
    print(0)
else:
    print(a - x)