from fractions import gcd

T = int(input())

for _ in range(T):
    a, b, c, d = map(int, input().split())

    if a < b or d < b:
        flag = False
    elif c >= b - 1:
        flag =  True
    else:
        g = gcd(b, d)
        flag = (b + a % g - g) <= c

    if flag:
        print("Yes")
    else:
        print("No")
