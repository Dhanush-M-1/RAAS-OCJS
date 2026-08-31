'''def xor(x,y,z):
    res = 0
    for i in range(31,-1,-1):
        b1 = x&(1 << i)
        b2 = y&(1 << i)
        b3 = z&(1 << i)
        b1 = min(b1 , 1)
        b2 = min(b2 , 1)
        b3 = min(b2 , 1)

        xorBit = 0
        if(b1&b2&b3):
            xorBit = 0
        else:
            xorBit = (b1|b2|b3)

        res <<= 1;
        res |=xorBit
    return res

t=int(input())
for _ in range(t):
    x,y,z=map(int,input().split())
    if(z==0):
        print(xor(x,z,y))
    else:
        print(xor(x,y,z))
'''

'''t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    print(min(a),max(a))
'''

from operator import xor
t=int(input())
for _ in range(t):
    a,b,n=map(int,input().split())
    f = [a , b , a ^ b]
    print(f[n%3])
