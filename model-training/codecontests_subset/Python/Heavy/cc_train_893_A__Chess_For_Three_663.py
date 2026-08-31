flag  = True
n = int(input())
j = ['1', '2']
for i in range(n):
    a = int(input())
    if('1' in j and '2' in j):
        if(a == 3):
            flag  = False
        else:
            if(a == 1):
                j.remove('2')
            else:
                j.remove('1')
            j.append('3')
    elif('1' in j and '3' in j):
        if(a == 2):
            flag  = False
        else:
            if(a==1):
                j.remove('3')
            else:
                j.remove('1')
            j.append('2')
    elif('3' in j and '2' in j):
        if(a == 1):
            flag  = False
        else:
            if(a==2):
                j.remove('3')
            else:
                j.remove('2')
            j.append('1')
if(flag):
    print('YES')
else:
    print('NO')
