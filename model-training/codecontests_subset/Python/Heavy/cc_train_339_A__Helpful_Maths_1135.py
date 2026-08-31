# 096A football
"""
a = input()
if (a.find('0000000') + 1 >= 1) or (a.find('1111111') + 1) >= 1:
    print('YES')
else:
    print('NO')
#print (a.find('0000000'))
#print (a.find('1111111'))
"""
"""
# 112A Petya i stroki
a = input()
b = input()
a = a.lower()
b = b.lower()
if a == b:
    print('0')
for i in range(0, len(a)):
    if ord(a[i]) > ord(b[i]):
        print('1')
        break
    elif ord(a[i]) < ord(b[i]):
        print('-1')
        break
"""
#339A Matematika speshit na pomosh'
a = input()
b = a.split('+')
b.sort()
a = '+'.join(b)
print(a)












