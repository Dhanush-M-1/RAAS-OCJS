import os

from collections import defaultdict, deque

is_dev = 'vscode' in os.environ

if is_dev:
    inF = open('in.txt', 'r')
    outF = open('out.txt', 'w')

def ins():
    return list(map(int, input_().split(' ')))

def inss():
    return list(input_().split(' '))

def input_():
    if is_dev:
        return inF.readline()[:-1]
    else:
        return input()
    
def ranin():
    return range(int(input_()))

def print_(data):
    if is_dev:
        outF.write(str(data)+'\n')
    else:
        print(data)

k = 1e9 + 7
n = int(input_())

x = 1
for i in range(1,n+1):
    x *= i
    x = int(x % k)

j = 1
for i in range(n-1):
    j *= 2
    j %= k
    
if x <= j:
    print_(int((k + x) - j))
else:
    print_(int(x - j))
    
if is_dev:
    outF.close()
    def compare_file():
        print(open('out.txt', 'r').read() == open('outactual.txt', 'r').read())
    compare_file()
