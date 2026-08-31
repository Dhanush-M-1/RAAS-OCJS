import sys
from itertools import islice

# stdin = open('input.txt', 'r')
stdin = sys.stdin

T = stdin.readline()
T = int(T)

def solve(data):
    prev_p = prev_c = 0
    
    for p, c in data:
        if p < prev_p or c < prev_c:
            return 'NO'
        
        if c - prev_c > p - prev_p:
            return 'NO'
        
        prev_p = p
        prev_c = c
        
    return 'YES'
        
for test_idx in range(T):
    n = stdin.readline()
    n = int(n)
    
    data = [[int(y) for y in x.split()]
             for x in islice(stdin, n)]
    # print(data)
        
    result = solve(data)
    print(result)
    # break