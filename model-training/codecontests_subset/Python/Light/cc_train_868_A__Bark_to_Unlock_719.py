s = input()
n = int(input())
words = [input() for word in range(n)]
ans = 'NO'
if s in words:
    ans = 'YES'
start, end = False, False
for word in words:
    if word[0] == s[1]:
        start = True
    if word[1] == s[0]:
        end = True
    if start and end:
        break
if start and end:
    ans = 'YES'
print(ans)