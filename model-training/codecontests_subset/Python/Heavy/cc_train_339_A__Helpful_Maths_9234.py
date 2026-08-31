s = input()
i = 0
j = 0
s1 = 0
s2 = 0
s3 = 0
n = len(s)
while i < n:
    if s[i] == '1':
        s1 += 1
    elif s[i] == '2':
        s2 += 1
    elif s[i] == '3':
        s3 += 1
    i += 1
i = 0
while i < s1:
    print('1', end='')
    i += 1
    j += 1
    if j < s1 + s2 + s3:
        print('+', end='')
i = 0
while i < s2:
    print('2', end='')
    i += 1
    j += 1
    if j < s1 + s2 + s3:
        print('+', end='')
i = 0
while i < s3:
    print('3', end='')
    i += 1
    j += 1
    if j < s1 + s2 + s3:
        print('+', end='')
