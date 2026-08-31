import sys
import math

#to read string
get_string = lambda: sys.stdin.readline().strip()
#to read list of integers
get_list = lambda: list( map(int,sys.stdin.readline().strip().split()) )
#to read non spaced string and elements are integers to list of int
get_intList_from_str = lambda: list(map(int,list(sys.stdin.readline().strip())))
#to read non spaced string and elements are character to list of character
get_charList_from_str = lambda: list(sys.stdin.readline().strip())
#to read integers
get_int = lambda: int(sys.stdin.readline().strip())
#to print faster
pt = lambda x: sys.stdout.write(str(x))

#--------------------------------WhiteHat010--------------------------------------#
n,m = get_list()
s = set()
for _ in range(n):
    s.update(get_list()[1:])

flag = True
for i in range(1,m+1):
    if i not in s:
        print("NO")
        flag = False
        break
    
if flag:
    print("YES")

