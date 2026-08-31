a, b = [int(i) for i in input().split()]

res = a

while(a >=b ):
    a -= b
    a += 1
    res += 1

print(int(res))