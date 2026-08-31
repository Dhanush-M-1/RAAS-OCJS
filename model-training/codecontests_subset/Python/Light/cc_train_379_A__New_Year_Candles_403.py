# You
# Dont read my code
full , n = map(int,input().split())
half , ans = 0,0
ans += full
half += full
while half // n > 0:
    full = half // n
    half = half % n
    ans += full
    half += full
print(ans)