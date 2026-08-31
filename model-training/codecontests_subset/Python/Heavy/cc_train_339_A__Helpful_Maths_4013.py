import sys

one = 0
two = 0
three = 0
string = input()
for i in string:
    if i is '1':
        one += 1
    elif i is '2':
        two += 1
    elif i is '3':
        three += 1


while one:
    if one == 1 and not two and not three:
        print('1')
    else:
        print('1+', end="")
    one -= 1

while two:
    if two == 1 and not three:
        print('2')
    else:
        print('2+', end="")
    two -= 1

while three:
    if three == 1:
        print('3')
    else:
        print('3+', end="")
    three -= 1