password = input()
n = int(input())
language = []
z = 0
for i in range(n):
    words = input()
    language.append(words)

for i in language:
    for k in language:
        a = i + k
        if password in a:
            z = 1
            break
    if z == 1:
        break

if z == 1:
    print('YES')
else:
    print('NO')
    
