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
a = get_int()
b = get_int()

d = (a+b)//2
first = abs(d-a)
second = abs(b-d)

print( first*(first+1)//2 + second*(second+1)//2)