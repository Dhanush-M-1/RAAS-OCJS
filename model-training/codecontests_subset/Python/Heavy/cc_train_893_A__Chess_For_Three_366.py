import sys
import math

#to read string
get_string = lambda: sys.stdin.readline().strip()
#to read list of integers
get_int_list = lambda: list( map(int,sys.stdin.readline().strip().split()) )
#to read non spaced string and elements are integers to list of int
get_intList_from_str = lambda: list(map(int,list(sys.stdin.readline().strip())))
#to read non spaced string and elements are character to list of character
get_charList_from_str = lambda: list(sys.stdin.readline().strip())
#get word sepetared list of character
get_char_list = lambda: sys.stdin.readline().strip().split() 
#to read integers
get_int = lambda: int(sys.stdin.readline())
#to print faster
pt = lambda x: sys.stdout.write(str(x))

#--------------------------------WhiteHat010--------------------------------#
n = get_int()
lst = [ get_int() for _ in range(n)]
state = 1   #state = 1 if 1 and 2 are playing, 2 if 2 and 3,3 if 1 and 3
win = [0]*3 #count point of each

valid = True
for i in range(n):
    if state == 1:
        #1 and 2
        if lst[i] == 1:
            state = 3
        elif lst[i] == 2:
            state = 2
        else:
            valid = False 
            break
    elif state == 2:
        #2 and 3
        if lst[i] == 2:
            state = 1
        elif lst[i] == 3:
            state = 3
        else:
            valid = False 
            break
    else:   #state = 3
        #1 and 3
        if lst[i] == 1:
            state = 1
        elif lst[i] == 3:
            state = 2
        else:
            valid = False 
            break
if valid:
    print("YES")
else:
    print("NO")
