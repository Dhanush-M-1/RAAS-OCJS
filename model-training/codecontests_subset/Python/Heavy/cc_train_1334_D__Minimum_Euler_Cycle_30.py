from sys import *
t = int(stdin.readline())
import math
for _ in range(t):
    n,l,r = list(map(int,stdin.readline().split(' ')))
    
    if(l == n*n-n+1):
        print('1')
        continue
    k = math.ceil(((2*n-1) - math.sqrt((2*n-1)**2 - 4*l))/2)
    s = k*(2*n-1 -k)
    sl = 2*(n-k)
    lb = k
    eb = k+1+math.ceil((l-s+sl)/2)-1
    while(l <= r):
        if(l == n*n-n+1):
            break
        if(l%2 == 0):
            stdout.write(str(eb)+' ')
            eb = eb+1
            if(eb > n):
                lb = lb+1
                eb = lb+1
        else:
            stdout.write(str(lb)+' ')
        l = l+1
    if(r == n*n-n+1):
        stdout.write('1')
    stdout.write('\n')