string=input().split('+')
one=0
two=0
three=0
for c in string:
    if c=='1':
        one+=1
    elif c=='2':
        two+=1
    else:
        three+=1
if one!=0:
    print('1',end='')
    for i in range(one-1):
        print('+1',end='')
    if two!=0:
        for i in range(two):
            print('+2',end='')
        if three !=0:
            for i in range(three):
                print('+3',end='')
    else:
        if three!=0:
            for i in range(three):
                print('+3',end='')
else:
    if two!=0:
        print('2',end='')
        for i in range(two-1):
            print('+2',end='')
        if three!=0:
            for i in range(three):
                print('+3',end='')
    else:
        if three!=0:
            print('3',end='')
            for i in range(three-1):
                print('+3',end='')
        else:
            print('0')