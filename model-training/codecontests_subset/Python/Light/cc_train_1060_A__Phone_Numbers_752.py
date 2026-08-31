n = int(input())
s = input()
ans = 0

if '8' in s:
    ans = len(s) // 11
    if ans > s.count('8'):
        ans = s.count('8')

print(ans)   
