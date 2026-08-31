import sys
import os
from collections import Counter, deque, defaultdict
import itertools
import math
import io
 
#inputs
def ii():return int(input())
def li():return list(map(int,input().split()))
def mi():return map(int,input().split())

#fns
def gcd(x, y): # math.gcd is slower
    """ returns greatest common divisor of x and y """
    while y:
        x, y = y, x % y
    return x
 
def check_sorted(a):
    ''' returns True/False '''
    for i in range(len(a)-1):
        if a[i]>a[i+1]:
            return False
    return True

def divs(n, start=1):
    """ returns a list of all divisors till n """
    divisors = []
    #rdivisors=[]
    for i in range(start, int(math.sqrt(n) + 1)):
        if n % i == 0:
            if n / i == i:
                divisors.append(i)
            else:
                divisors.extend([i, n // i])
    return divisors

############# MAIN CODE ###############################################################

def main():
    for i in range(ii()):
        one,two = mi()
        oneli = li()
        twoli = li()
        oneset = set(oneli)
        intersect= oneset.intersection(twoli)
        il=list(intersect)
        if len(intersect)==0:
            print("NO")
            continue
        if len(intersect)>0:
            print("YES")
            print(1,il[0])
            continue

    








#######################################################################################
if __name__ == "__main__":
    main()

    