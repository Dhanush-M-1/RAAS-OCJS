from sys import stdin, stdout
from collections import Counter
import math
 
def rsingle_int():
    return int(stdin.readline().rstrip())
 
def rmult_int():
    return [ int(x) for x in stdin.readline().rstrip().split() ]
 
def rmult_str():
    return stdin.readline().rstrip().split()
 
def r_str():
    return stdin.readline().rstrip()
    
def rsingle_char():
    return stdin.read(1)
 
def sortFirst(val):
    return val[0]
 
def main():
    n, p, w, d = rmult_int()
    if p == 0:
        print(*[0, 0, n])
    elif p > w * n:
        # print('impossible')
        print(-1)
    else:
        possible = False
        for y in range(0, w):
            win_p = p - (d * y)
            rem = win_p % w
            x = win_p // w
            if win_p >= 0 and rem == 0 and ((y + x) <= n):
                possible = True
                print(*[x, y, n - x - y])
                break
        if not possible:
            print(-1)
     
 
main()