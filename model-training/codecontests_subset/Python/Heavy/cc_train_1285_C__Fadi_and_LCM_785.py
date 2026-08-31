import itertools
import math
from functools import reduce

def multiply(values):
    prod = 1
    for a in values:
        prod *= a
    return prod

value = int(input())
n = value
maxFactors = []
twos = 1
while n%2 == 0:
    twos *= 2
    n /= 2
if twos != 1:
    maxFactors.append(twos)
for a in range(3,int(math.sqrt(n))+1,2):
    total = 0
    while n%a == 0:
        total += 1
        n/=a
    if total != 0:
        maxFactors.append(a**total)
if n > 2:
    maxFactors.append(n)
maxFactors = list(map(int,maxFactors))
maxFactors.sort()
allFactors = []
for a in range(len(maxFactors)+1):
    allFactors += list(map(multiply,itertools.combinations(maxFactors,a)))
closest = allFactors[0]
difference = abs(closest - math.sqrt(value))
for a in allFactors:
    dif = abs(a - math.sqrt(value))
    if dif < difference:
        closest = a
        difference = dif
print(closest, int(value/closest))
