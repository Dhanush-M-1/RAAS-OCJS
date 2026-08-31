import sys
import math

#to read string
get_string = lambda: sys.stdin.readline().strip()
#to read list of integers
get_list = lambda: list( map(int,sys.stdin.readline().strip().split()) )
#to read non spaced string and elements are integers to list of int
get_intList_from_str = lambda: list(map(int,list(sys.stdin.readline().strip())))
#to read non spaced string and elements are character to list of character
get_strList_from_str = lambda: list(sys.stdin.readline().strip())
#to read integers
get_int = lambda: int(sys.stdin.readline().strip())
#to print faster
pt = lambda x: sys.stdout.write(str(x))

#--------------------------------WhiteHat010--------------------------------------#
n = get_int()
for _ in range(n):
    a,b,c = get_list()
    count = 0

    if 2*b >= c:
        count += 3*(c//2)
        b = b - (c//2)
        if b > 1 and a >= b//2:
            count += 3*(b//2)
        elif b>1 and a < b//2:
            count += 3*a

    else:
        count += 3*b
    print(count)

            