# Aizu Problem 0206: The Next Trip

import sys, math, os

# read input:
PYDEV = os.environ.get('PYDEV')
if PYDEV=="True":
    sys.stdin = open("sample-input.txt", "rt")


def next_trip(L, cashflow):
    saved = 0
    month = 0
    for m, n in cashflow:
        month += 1
        saved += (m - n)
        if saved >= L:
            return month
    return "NA"

    
while True:
    L = int(input())
    if L == 0:
        break
    cashflow = [[int(_) for _ in input().split()] for __ in range(12)]
    print(next_trip(L, cashflow))