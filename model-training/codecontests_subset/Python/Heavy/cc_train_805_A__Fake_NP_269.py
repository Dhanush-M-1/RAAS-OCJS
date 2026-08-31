l, r = [int(p) for p in input().split()]
from math import sqrt
from datetime import datetime
if r - l > 100:
    # 1 to 10
    max_div = 2
else:
    st = datetime.now()
    ov_divisors = {}
    max_div = 0
    max_div_count = 0
    for i in range(l, r+1):
        divisors = {}
        for j in range(1, int(sqrt(i))+2):
            if i % j == 0:
                if i not in divisors:
                    divisors[i] = 0
                if j not in divisors:
                    divisors[j] = 0
                divisors[i] = 1
                divisors[j] = 1
        for div, val in divisors.items():
            if val != 0:
                if div not in ov_divisors:
                    ov_divisors[div] = 0
                ov_divisors[div] += 1
                if max_div_count < ov_divisors[div] and div != 1:
                    max_div_count = ov_divisors[div]
                    max_div = div
print(max_div)