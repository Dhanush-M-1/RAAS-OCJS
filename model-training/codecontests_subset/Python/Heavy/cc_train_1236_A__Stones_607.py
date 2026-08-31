# -*- coding: utf-8 -*-
"""

@author: sifat_shikdar
"""

t = int(input())

for t in range(t):
    result = 0
    a,b,c = map(int,input().split())
    if b == 0:
        result = 0
    else:
        if c>=2 and b>=1:
            temp = int(c/2)
            if temp>b:
                temp = b
                while temp*2 > c:
                    temp-=1
                b -= temp
                result += temp*2 + temp
            else:
                result += temp*2 + temp
                b -= temp
        if b>=2 and a>=1:
            temp = int(b/2)
            if temp > a:
                temp = a
                while temp*2 > b:
                    temp-=1
                a -=temp
                result +=temp*2 + temp
            else:
                result += temp*2 + temp
    print(result)