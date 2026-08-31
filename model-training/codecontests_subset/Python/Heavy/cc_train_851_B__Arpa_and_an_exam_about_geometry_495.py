import math 
import sys
import decimal
decimal.getcontext().prec = 100

ax, ay, bx, by, cx, cy = list(map(decimal.Decimal, input().split()))

absq = (ax - bx) ** decimal.Decimal(2) + (ay - by) ** decimal.Decimal(2)
bcsq = (bx - cx) ** decimal.Decimal(2) + (by - cy) ** decimal.Decimal(2)
acsq = (ax - cx) ** decimal.Decimal(2) + (ay - cy) ** decimal.Decimal(2)

on_one_line = False
# print(absq, bcsq, acsq)
lengths = sorted([absq ** decimal.Decimal(.5), bcsq ** decimal.Decimal(.5), acsq ** decimal.Decimal(.5)])
# print(lengths)
if lengths[0] + lengths[1] - lengths[2] < sys.float_info.epsilon:# 0.0000000000000000000000000000000000001:
	on_one_line = True

if absq == bcsq and not on_one_line:
	print("Yes")
else:
	print("No")