__author__ = 'linh'

import math

def main():
    n = input().split()
    A = int(n[0])
    B = int(n[1])
    C = int(n[2])

    if A==B==C==0:
        print(-1)
    elif A==B==0:
        print(0)
    elif A==0:
        print(1)
        print("{0:.5f}".format(-C/B))
    else:
        delta = B**2 -4*A*C
        if delta <0:
            print(0)
        elif delta ==0:
            print(1)
            print("{0:.5f}".format(-B/(2*A)))
        else:
            print(2)
            x1 = (-B-math.sqrt(delta))/(2*A)
            x2 = (-B+math.sqrt(delta))/(2*A)
            if x1<x2:
                print("{0:.20f}".format(x1))
                print("{0:.20f}".format(x2))
            else:
                print("{0:.20f}".format(x2))
                print("{0:.20f}".format(x1))



if __name__ == '__main__':
    main()