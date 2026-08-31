import sys
from collections import defaultdict


def stdinWrapper():
    data = '''6
1 4 3 3 5 7
3 7 5 4 3
4 3 7 5
'''
    for line in data.split('\n'):
        yield line

if '--debug' not in sys.argv:
    def stdinWrapper():
        while True:
            yield input()

inputs = stdinWrapper()

def inputWrapper():
    return next(inputs)

def getType(_type):
    return _type(inputWrapper())

def getArray(_type):
    return [_type(x) for x in inputWrapper().split()]

lines = getType(int)
source = getArray(int)
sourceFixed1 = getArray(int)
sourceFixed2 = getArray(int)

sums = [sum(x) for x in [source, sourceFixed1, sourceFixed2]]

print(sums[0] - sums[1])
print(sums[1] - sums[2])