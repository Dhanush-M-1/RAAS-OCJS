#!/usr/bin/env python3
# encoding: utf-8



#----------
# Constants
#----------



#----------
# Functions
#----------

# The function that solves the task
def calc(a):
    n = len(a)
    # TODO
    s = sum(a)
    k = (2 * s) // n + 1
    return max(k, max(a))


# Reads a string from stdin, splits it by space chars, converts each
# substring to int, adds it to a list and returns the list as a result.
def get_ints():
    return [ int(n) for n in input().split() ]


# Reads a string from stdin, splits it by space chars, converts each substring
# to floating point number, adds it to a list and returns the list as a result.
def get_floats():
    return [ float(n) for n in input().split() ]


#----------
# Execution start point
#----------

if __name__ == "__main__":
    a = get_ints()
    assert len(a) == 1
    n = a[0]
    a = get_ints()
    assert len(a) == n

    k = calc(a)
    print(k)
