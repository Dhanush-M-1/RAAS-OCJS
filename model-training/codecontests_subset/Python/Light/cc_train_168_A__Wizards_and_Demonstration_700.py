
from math import ceil
n, x, y = list(map(int, input().split()))
final = (ceil((n * y) / 100)) - x
if final < 0:
    print(0)
else:
    print(final)

# CodeForcesian
# ♥
# اگه ایمان داری که روزای خوب تو راهن
# روزای خوب قطعا به سمتت میاد
