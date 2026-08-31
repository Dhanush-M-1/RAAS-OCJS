t = int(input())

import fractions

for _ in range(t):
    a,b,c,d = map(int, input().split())

    if(b > d)|(a < b):
        print('No')
        continue

    if(b <= c):
        print('Yes')
        continue

    c1 = a - (1+(a-c-1)//b)*b
    if(c1 < 0):
        print('No')
        continue

    mod = fractions.gcd(b,d)
    red = c1 % mod

    for i in [0,1]:
        tmp = ((c//mod) + i)*mod + red
        if(c < tmp < b):
            print('No')
            break

        if(i==1):
            print('Yes')