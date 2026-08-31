import sys


def gcd(a, b):
    if a >= b:
        temp = 0
        while True:
            temp = a % b
            if temp == 0:
                return b
            a = b
            b = temp
    else:
        temp = 0
        while True:
            temp = b % a
            if temp == 0:
                return a
            b = a
            a = temp


n = int(sys.stdin.readline())

a = list(map(int, sys.stdin.readline().split()))

a_dist = []
maxVal = max(a)

for i in range(n):
    a_dist.append(maxVal - a[i])

sumVal = sum(a_dist)
_gcd = 0
judge1 = False
for j in range(n):
    if judge1 == False and a_dist[j] != 0:
        _gcd = a_dist[j]
        judge1 = True
    if judge1 == True and a_dist[j] != 0:
        _gcd = gcd(_gcd, a_dist[j])
print(sumVal // _gcd, _gcd)
