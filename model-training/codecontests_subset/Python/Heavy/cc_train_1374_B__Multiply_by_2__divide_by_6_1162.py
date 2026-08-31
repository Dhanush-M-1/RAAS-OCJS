#!/usr/bin/python3

import getopt
import sys
import math

if __name__ == "__main__":
    onlyCase = -1
    verbose = False
    
    try:
         opts, args = getopt.getopt(sys.argv[1:], "vc:",
                                   ["case="])
    except getopt.GetoptError as err:
        print (str(err)) 
        sys.exit(2)

    for o, a in opts:
        if o in ("-c", "--case"):
            onlyCase = int(a)
        elif o  == "-v":
            verbose = True
        else: sys.exit()

    
    ncases = int(input())
    for c in range(1, ncases + 1):
        n = int(input())

        if onlyCase != -1 and onlyCase != c:
            continue

        # find how often divisible by 3 and 2
        d3 = 0
        d2 = 0

        x = n
        while x % 3 == 0:
            x = x // 3
            d3 += 1

        while x % 2 == 0:
            x = x // 2
            d2 += 1

        if verbose:
            print("%d by 3: %d by 2 %d (left: %d)" % (n,d3,d2, x)) 

        if d2 > d3 or x != 1:
            print("-1")
        else:
            print("%d" % (2*d3 - d2))





        

        




