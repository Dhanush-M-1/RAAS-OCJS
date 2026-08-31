
import sys
def get_single_int ():
    return int (sys.stdin.readline ().strip ())
def get_string ():
    return sys.stdin.readline ().strip ()
def get_ints ():
    return map (int, sys.stdin.readline ().strip ().split ())
def get_list ():
    return list (map (int, sys.stdin.readline ().strip ().split ()))

#code starts here
for i in range (get_single_int ()):
    a, b, c = get_ints ()
    summ = 0
    while (b > 0 and c > 1):
        b-= 1
        c-=2
        summ += 3
    if (b == 0):
        print (summ)
        continue
    else:
        while ( b > 1 and a > 0):
            b -= 2
            a -= 1
            summ += 3
    print (summ)
