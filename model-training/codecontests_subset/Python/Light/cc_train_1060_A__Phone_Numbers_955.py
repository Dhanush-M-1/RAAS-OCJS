n = input()
s = input()
n = int(n)
inp = []

length = len(s)

for i in range(0, length):
    inp.append(int(s[i]))

count = inp.count(8)

from math import *



total = floor(length/11)
if total < count:
    print(total, end='')
else:
    print(count, end='')