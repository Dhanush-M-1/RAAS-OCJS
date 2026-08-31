# -*- coding: utf-8 -*-

x = int(input())
                        
if x == 1:
    print(1, 1)
else:
    r = x**(1/2)
    r0 = int(r)
    if r0*r0 == x:
        r0 -= 1
    
    fl = True
    
    def check(x1,x2):
        mmin = min(x1,x2)
        res = True
        
        if mmin != 1:
            f = True
            while f:
                if x1 % mmin == 0 and x2 % mmin == 0:
                    f = False
                    res = False
                
                mmin -= 1
                if mmin == 1:
                    f = False
            
        return res
    
    while fl:
        if x % r0 == 0:
            a = x // r0
            b = x // a
            
            if check(a,b):
                fl = False
                
            else:
                r0 -= 1
            
        else:
            r0 -= 1
            
        if r0 == 0:
            fl = False
            a = 1
            b = x
            
            
    print(a, b)