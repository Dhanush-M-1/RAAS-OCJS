from sys import stdin
from fractions import gcd
columns = int(stdin.readline().rstrip())
datas = [stdin.readline().rstrip().split() for _ in range(columns)]
for data in datas:
    A = int(data[0])
    B = int(data[1])
    C = int(data[2])
    D = int(data[3])
    if A < B:
        print("No")
        continue
    if D < B:
        print("No")
        continue
    if C > B:
        print("Yes")
        continue
    g = gcd(B,D)
    if (B - g + A % g) >C :
        print("No")
    else:
        print("Yes")     
    