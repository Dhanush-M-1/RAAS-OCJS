#!/usr/bin/env python
# -*- coding: utf-8 -*-

from math import *

functions = dict()
functions['J'] = lambda s: s[1:]+s[0]
functions['C'] = lambda s: s[-1] + s[:-1]
functions['A'] = lambda s: ''.join(reversed(s))
functions['E'] = lambda s: s[ceil(len(s)/2):] + s[len(s)//2:ceil(len(s)/2)] + s[:len(s)//2]
functions['P'] = lambda s: ''.join([str((int(c)+1)%10) if c.isnumeric() else c for c in s])
functions['M'] = lambda s: ''.join([str((int(c)-1)%10) if c.isnumeric() else c for c in s])

inv = {'J':'C','C':'J','A':'A','E':'E','P':'M','M':'P'}

n = int(input())
for i in range(n):
    order = input()
    message = str(input())
    for o in list(reversed(order)):
        message = functions[inv[o]](message)
    print(message)