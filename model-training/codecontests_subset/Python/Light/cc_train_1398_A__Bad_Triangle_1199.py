import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    x = int(input())
    n = list(map(int,input().split()))
    
    if n[0] + n[1] <= n[-1]:
        print(1,2,len(n))
    else:
        print(-1)