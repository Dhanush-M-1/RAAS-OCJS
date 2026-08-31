import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

def solve():
    n = int(input())
    r = list(map(int, input().split()))
    c = list(map(int, input().split()))
    
    points = []
    for ri, ci in zip(r, c):
        ri -= 1
        ci -= 1
        points.append((ri-ci, ci))
        
    points.sort()
    
    total = 0
    r, c = 0, 0
    for rp, cp in points:
        total += (rp-r)//2
        if rp%2==0 and r%2==1:
            total += 1
        if rp == r and rp%2 == 0:
            total += cp-c
        r, c = rp, cp
    print(total)
    
    
t = int(input())

for _ in range(t):
    solve()
