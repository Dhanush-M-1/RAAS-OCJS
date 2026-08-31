#import sys
#from io import StringIO

#sys.stdin = StringIO(open(__file__.replace('.py', '.in')).read())

n = int(input())
a = set(map(int, input().split()))

l = 1
r = 10 ** 6

for i in range(1, 10 ** 6 + 1):
    if l + i in a:
        n -= 1
    if r - i in a:
        n -= 1
    if n <= 0:
        print(i)
        break
