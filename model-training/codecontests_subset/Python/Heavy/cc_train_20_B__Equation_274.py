import sys
import math
input = sys.stdin.readline

############ ---- Input Functions ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))

if __name__ == '__main__':
    q = inlt()
    a = q[0]
    b = q[1]
    c = q[2]

    if a == 0 :
        if b == 0 and c == 0 :
            print("-1")
        else :
            if b == 0 :
                print("0")
            else :
                print("1")
                print("{:.6f}".format(-1*c / b))
    else :
        d = b*b - 4*a*c
        if d > 0 :
            print("2")
            bb = [ (-1*b + math.sqrt(d))/(2*a) ,(-1*b - math.sqrt(d))/(2*a) ]
            bb.sort()
            print("{:.6f}".format(bb[0]))
            print("{:.6f}".format(bb[1]))
        else :
            if d == 0 :
                print("1")
                print("{:.6f}".format(-b/(2*a)))
            else :
                print("0")