password = input()

n = int(input())

firstLetter = 0
secondLetter = 0
found = 0

for i in range(n):
    string = input()

    if string == password:
        found = 1

    if string[1] == password[0]:
        firstLetter = 1

    if string[0] == password[1]:
        secondLetter = 1


if ( found or (firstLetter and secondLetter) ):
    print('YES')
else:
    print('NO')