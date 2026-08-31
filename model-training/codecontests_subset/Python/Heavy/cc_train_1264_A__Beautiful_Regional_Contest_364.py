n = int(input())

from collections import Counter
from itertools import accumulate

def solve():
    k = int(input())
    l = k//2
    arr = [int(i) for i in input().split()]
    count = Counter(arr)
    
    cumul = [n for i, n in zip(count, accumulate(i for i in count.values())) if n <= l ]
    
    if len(cumul) < 3:
        return "0 0 0"
    try:
        mid = next(cumul[i] for i in range(1, len(cumul)) if cumul[i] - cumul[0] > cumul[0])
    except:
        return "0 0 0"
    
    if cumul[-1] - mid > cumul[0]:
        return f'{cumul[0]} {mid - cumul[0]} {cumul[-1] - mid}'
    return "0 0 0"
    

for _ in range(n):
    print(solve())