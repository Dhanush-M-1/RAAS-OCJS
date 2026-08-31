input()
S = input()

t = len(S)
e = S.count('8')

ans = 0

while t >= 11 and e > 0:
    e -= 1
    t -= 11
    ans += 1
print(ans)    
    