#!/usr/bin/env python
import math

def main():

    # Read input
    i = input().split()
    a = int( i[0] )
    b = int( i[1] )

    x = a
    e = 0 # extra
    
    while int(a/b + e) > 0:
        
        t = (a/b + e)
        e = t - int(t)
        a = int(t)
        x += a

    print(x)

if __name__ == '__main__':
    main()