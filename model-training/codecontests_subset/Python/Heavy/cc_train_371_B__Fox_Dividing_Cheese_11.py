import math
a, b = map(int, input().split())
if a == b:
    print(0)
    exit()
g = math.gcd(a, b)
a = a // g
b = b // g
cnt = 0
while True:
    if a % 2 and a % 3 and a % 5 and b % 2 and b % 3 and b % 5:
        print(-1)
        exit()
    if b % 2 == 0:
        b = b // 2
        cnt = cnt + 1
    if b % 3 == 0:
        b = b // 3
        cnt = cnt + 1
    if b % 5 == 0:
        b = b // 5
        cnt = cnt + 1
    if a % 2 == 0:
        a = a // 2
        cnt = cnt + 1
    if a % 3 == 0:
        a = a // 3
        cnt = cnt + 1
    if a % 5 == 0:
        a = a // 5
        cnt = cnt + 1
    if a == b:
        break
 
print(cnt)