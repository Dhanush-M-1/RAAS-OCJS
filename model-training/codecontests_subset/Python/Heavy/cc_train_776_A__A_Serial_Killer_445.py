from sys import stdin,stdout,maxsize;# mod = int(1e9 + 7);#import re  # can use multiple splits
tup = lambda: map(int, stdin.readline().split())
I = lambda: int(stdin.readline())
lint = lambda: [int(x) for x in stdin.readline().split()]
#S = lambda: stdin.readline().replace('\n', '').strip()
#def grid(r, c): return [lint() for i in range(r)]
#def debug(*args, c=6): print('\033[3{}m'.format(c), *args, '\033[0m', file=stderr)
stpr = lambda x  : stdout.write(f'{x}' + '\n')
star = lambda x : print(' '.join(map(str , x)))
a , b = input().split()
print(a , b)
for _ in range(I()):
    c , d = input().split()
    if c==a:
        a = d
    else:
        b = d
    print(a , b)

















