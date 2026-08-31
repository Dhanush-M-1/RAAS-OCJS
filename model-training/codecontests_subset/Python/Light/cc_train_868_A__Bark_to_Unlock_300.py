k = str(input())
n = int(input())
s = []

for i in range(n):
    s.append(str(input()))
    
pri = ''

if k in s:
    pri = 'YES'
else:
    for i in range(len(s)):
        for j in range(len(s)):
            if k in str(s[i]) + str(s[j]) or k in str(s[j]) + str(s[i]):
                pri = 'YES'
                break
if pri == '':
    pri = 'NO'

print(pri)