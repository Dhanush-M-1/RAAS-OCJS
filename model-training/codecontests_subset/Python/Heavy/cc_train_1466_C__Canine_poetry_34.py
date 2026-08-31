import io
import os

#input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

def solve():
    s = list(map(lambda c: ord(c)-ord('a'), input()))
    cost = 0
    for i in range(1, len(s)):
        if s[i] == s[i-1] or (i >= 2 and s[i] == s[i-2]):
            opt = set(range(26))
            for pos in [i-2, i-1, i+1, i+2]:
                try:
                    opt.remove(s[pos])
                except:
                    pass
            s[i] = list(opt)[0]
            cost += 1
    print(cost)
        
    
t = int(input())

for _ in range(t):
    solve()
