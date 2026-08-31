import itertools
import math
import sys
from collections import defaultdict

 
def is_debug():
    return '--debug' in sys.argv

def stdin_wrapper():
    data = '''3
4
S010
0001
1000
111F
3
S10
101
01F
5
S0101
00000
01111
11111
0001F

'''
    
    for line in data.split('\n'):
        yield line
 
if not is_debug():
    def stdin_wrapper():
        while True:
            yield sys.stdin.readline()
 
inputs = stdin_wrapper()
 
def input_wrapper():
    return next(inputs)
 


def get_str():
    if is_debug():
        return input_wrapper()

    return input()

def get(_type):
    if _type == str:
        return get_str()

    return _type(input_wrapper())
 
def get_arr(_type):
    return [_type(x) for x in input_wrapper().split()]
 

def tuplerize(method):
    def wrap(*args, **kwargs):
        res = method(*args, **kwargs)
        if not isinstance(res, (tuple, list)):
            res = (res, )

        return res
    return wrap

''' Solution '''
@tuplerize
def solve(data):
    c = [
        int(data[0][1]),
        int(data[1][0]),
        int(data[-2][-1]),
        int(data[-1][-2]),
    ]
    coords = [(1,2), (2,1), (len(data)-1, len(data)), (len(data), len(data)-1)]

    if c[0] == c[1] and c[2] == c[3] and c[0] != c[2]:
        return 0

    res = []
    if c[0] == c[1]:
        target = 1 - c[0]
        if c[2] != target:
            res.append(coords[2])

        if c[3] != target:
            res.append(coords[3])

    elif c[2] == c[3]:
        target = 1 - c[2]
        if c[0] != target:
            res.append(coords[0])

        if c[1] != target:
            res.append(coords[1])


    else:
        target = 0

        if c[0] != target:
            res.append(coords[0])

        if c[1] != target:
            res.append(coords[1])

        target = 1 - target

        if c[2] != target:
            res.append(coords[2])

        if c[3] != target:
            res.append(coords[3])

    return '{}\n{}'.format(len(res), '\n'.join([' '.join(list(map(str, c))) for c in res]))


t = get(int)
for _ in range(t):
    rows = get(int)
    data = []
    for _ in range(rows):
        data.append(get_str())

    print(*solve(data))