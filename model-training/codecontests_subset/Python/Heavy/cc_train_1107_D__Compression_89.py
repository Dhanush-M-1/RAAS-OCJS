#!/usr/bin/env python
"""
This file is part of https://github.com/Cheran-Senthil/PyRival.

Copyright 2018 Cheran Senthilkumar all rights reserved,
Cheran Senthilkumar <hello@cheran.io>
Permission to use, modify, and distribute this software is given under the
terms of the MIT License.

"""
from __future__ import division, print_function

import cmath
import itertools
import math
import operator as op
# import random
import sys
from atexit import register
from bisect import bisect_left, bisect_right
# from collections import Counter, MutableSequence, defaultdict, deque
# from copy import deepcopy
# from decimal import Decimal
# from difflib import SequenceMatcher
# from fractions import Fraction
# from heapq import heappop, heappush
from io import BytesIO

if sys.version_info[0] < 3:
    # from cPickle import dumps
    # from Queue import PriorityQueue, Queue
    pass
else:
    # from functools import reduce
    # from pickle import dumps
    # from queue import PriorityQueue, Queue
    pass


if sys.version_info[0] < 3:
    class dict(dict):
        """dict() -> new empty dictionary"""
        def items(self):
            """D.items() -> a set-like object providing a view on D's items"""
            return dict.iteritems(self)

        def keys(self):
            """D.keys() -> a set-like object providing a view on D's keys"""
            return dict.iterkeys(self)

        def values(self):
            """D.values() -> an object providing a view on D's values"""
            return dict.itervalues(self)

    input = raw_input
    range = xrange

    filter = itertools.ifilter
    map = itertools.imap
    zip = itertools.izip


def sync_with_stdio(sync=True):
    """Set whether the standard Python streams are allowed to buffer their I/O.

    Args:
        sync (bool, optional): The new synchronization setting.

    """
    global input, flush

    if sync:
        flush = sys.stdout.flush
    else:
        if sys.version_info[0] < 3:
            sys.stdin = BytesIO(sys.stdin.read())
            input = lambda: sys.stdin.readline().rstrip('\r\n')

            sys.stdout = BytesIO()
            register(lambda: sys.__stdout__.write(sys.stdout.getvalue()))
        else:
            input = iter(sys.stdin.buffer.read().splitlines()).__next__

            print = lambda *args: sys.stdout.buffer.write(
                b' '.join(str(arg).encode('ascii') for arg in args)
            )



def gcd(x, y):
    """greatest common divisor of x and y"""
    while y:
        x, y = y, x % y
    return x


def main():
    hex2bin = ['']*256
    hex2bin[ord('0')] = b'0000'
    hex2bin[ord('1')] = b'0001'
    hex2bin[ord('2')] = b'0010'
    hex2bin[ord('3')] = b'0011'
    hex2bin[ord('4')] = b'0100'
    hex2bin[ord('5')] = b'0101'
    hex2bin[ord('6')] = b'0110'
    hex2bin[ord('7')] = b'0111'
    hex2bin[ord('8')] = b'1000'
    hex2bin[ord('9')] = b'1001'
    hex2bin[ord('A')] = b'1010'
    hex2bin[ord('B')] = b'1011'
    hex2bin[ord('C')] = b'1100'
    hex2bin[ord('D')] = b'1101'
    hex2bin[ord('E')] = b'1110'
    hex2bin[ord('F')] = b'1111'


    n = int(input())
    buckets = [0]*(n+1)

    prev = b''
    count = 0
    for _ in range(n):
        line = input()
        if line==prev:
            count += 1
        else:
            buckets[count] += 1
            count = 1
            prev = line

            prev_c = b''
            counter = 0
            for byte in prev:
                for c in hex2bin[byte]:
                    if c==prev_c:
                        counter += 1
                    else:
                        buckets[counter] += 1
                        counter = 1
                        prev_c = c
            buckets[counter] += 1
        if buckets[1]!=0 or (buckets[2]!=0 and buckets[3]!=0):
            print(1)
            sys.exit()

    buckets[count] += 1

    x = 0
    for i in range(1,n+1):
        if buckets[i]:
            while i:
                i,x=x%i,i
    print(x)


if __name__ == '__main__':
    sync_with_stdio(False)
    main()
