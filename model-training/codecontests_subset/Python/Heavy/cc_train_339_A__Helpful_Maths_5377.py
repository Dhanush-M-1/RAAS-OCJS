s = str(input())
a = list(s)
c1 = a.count('1')
c2 = a.count('2')
c3 = a.count('3')
for i in range(c1):
    print('1',sep = '',end ='')
    if i != c1-1:
        print('+',sep = '',end ='')
if c1 != 0 and (c2!= 0 or c3 != 0):
    print('+',sep = '',end ='')
for i in range(c2):
    print('2',sep = '',end ='')
    if i != c2-1:
        print('+',sep = '',end ='')
if c2 != 0 and c3!= 0 :
    print('+',sep = '',end ='')
for i in range(c3):
    print('3',sep = '',end ='')
    if i != c3-1:
        print('+',sep = '',end ='')