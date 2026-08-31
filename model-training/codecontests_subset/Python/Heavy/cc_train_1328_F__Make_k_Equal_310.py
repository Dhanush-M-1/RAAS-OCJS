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
    n, k = rmult_int()
    a = rmult_int()
    cnts = {}
    a.sort()
    for el in a:
        cnt = 0
        while el != 0:
            if el not in cnts:
                cnts[el] = []
            cnts[el].append(cnt)
            el = int(math.floor(el / 2))
            cnt += 1
        if el not in cnts:
            cnts[el] = []
        cnts[el].append(cnt)

    min_cost = float(math.inf)

    for el in cnts.keys():
        arr = cnts[el]
        if len(arr) >= k:
            sum_ = 0
            for i in range(k):
                sum_ += arr[i]
            if sum_ < min_cost:
                min_cost = sum_

    print(min_cost)


main()