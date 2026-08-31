from sys import maxsize, stdout, stdin, stderr
# mod = int(1e9 + 7)
import re  # can use multiple splits
tup = lambda: map(int, stdin.readline().split())
I = lambda: int(stdin.readline())
lint = lambda: [int(x) for x in stdin.readline().split()]
S = lambda: stdin.readline().replace('\n', '').strip()
def grid(r, c): return [lint() for i in range(r)]
def debug(*args, c=6): print('\033[3{}m'.format(c), *args, '\033[0m', file=stderr)
x , y = tup()
if x ==y:
    print(x)
    exit()
a=  x//2
b = y//2
f = b - a
q = x//3
w = y//3
o  = w- q
if x%3==0: o+=1
if x%2==0:f+=1
if o >=f:
    print(3)
else:print(2)







