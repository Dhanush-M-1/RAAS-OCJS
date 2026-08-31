import sys
 
n = int(input())
a = list(map(int, input().split()))
ans = 0
for x in a:
    ans = max(ans, min(x-1, 10**6-x))
 
print(ans)