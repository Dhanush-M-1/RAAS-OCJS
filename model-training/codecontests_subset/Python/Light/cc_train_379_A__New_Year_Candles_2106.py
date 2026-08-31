import math
import itertools

gh = lambda: map( int, input().split() )
mod = 998244353
mod = int(mod)

def main():
    x, y = gh()
    cnt = 0
    while x > 0:
        x -= 1
        cnt += 1
        if cnt % y == 0:
            x += 1
    print( cnt ) 

main()