s = input()
n = int(input())

first = ''
second = ''
ans = 'NO'

for _ in range(n):
    word = input()
    first += word[0]
    second += word[1]
    if word == s:
        ans = 'YES'

if first.count(s[1]) * second.count(s[0]) != 0:
    ans = 'YES'

print (ans)