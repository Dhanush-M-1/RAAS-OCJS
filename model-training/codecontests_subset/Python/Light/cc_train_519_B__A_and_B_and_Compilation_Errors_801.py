from operator import xor
from functools import reduce

input()
xor1 = reduce(xor, map(int, input().split()))
xor2 = reduce(xor, map(int, input().split()))
xor3 = reduce(xor, map(int, input().split()))

print(xor1 ^ xor2)
print(xor2 ^ xor3)