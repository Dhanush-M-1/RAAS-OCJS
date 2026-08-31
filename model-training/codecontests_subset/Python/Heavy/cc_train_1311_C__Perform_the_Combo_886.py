# t = int(f.readline())
t = int(input())

import bisect

for qwe in range(t):
    
    
    alf = {'a': 0, 'b': 0, 'c': 0, 'd': 0, 'e': 0, 'f': 0, 'g': 0, 'h': 0, 'i': 0, 'j': 0, 'k': 0, 'l': 0, 'm': 0, 'n': 0, 'o': 0, 'p': 0, 'q': 0, 'r': 0, 's': 0, 't': 0, 'u': 0, 'v': 0, 'w': 0, 'x': 0, 'y': 0, 'z': 0}
    
    # n, m = map(int, f.readline().split())
    n, m = map(int, input().split())
    
    # s = f.readline()[:-1]
    s = input()
    
    # p = list(map(int, f.readline().split()))
    p = list(map(int, input().split()))
    
    p.sort()
    
    for i in range(n):
        
        ind = bisect.bisect_left(p, i+1)
        alf[s[i]] += m - ind + 1
    
    for i in alf.values():
        print(i, end=" ")
    print()