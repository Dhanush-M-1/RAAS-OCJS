a = input()
n = int(input())

words = []

i = 0
while i < n:
    b = input()

    words.append(b)

    i += 1

match = False

for word1 in words:
    for word2 in words:
        if a in word1+word2:
            match = True
            break

if match:
    print('YES')
else:
    print('NO')
