s = input()
t = len(s)

nb1 = 0
nb2 = 0
nb3 = 0
for i in range(0, t, 2):
    if s[i] == '1':
        nb1 += 1
    elif s[i] == '2':
        nb2 += 1
    else:
        nb3 += 1

if nb1 != 0:
    nb1 -= 1
    print(1, end='')
elif nb2 != 0:
    nb2 -= 1
    print(2, end='')
else:
    nb3 -= 1
    print(3, end='')

for _ in range(nb1):
    print('+', end='')
    print(1, end='')

for _ in range(nb2):
    print('+', end='')
    print(2, end='')

for _ in range(nb3):
    print('+', end='')
    print(3, end='')

print()
