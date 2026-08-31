a=input()
b=int(input())
c=list()
r=0
while r<b:
    c.append(input())
    r=r+1
r=0
d=0
e=0
f=0
if a in c:
    d=2
else:
    while r<b:
        if a[0]==c[r][1] and e==0:
            #print('fffffffffffffffffffff')
            d=d+1
            e=1
        if a[1]==c[r][0] and f==0:
            #print('ggggggggggggggggggggggggggg')
            d=d+1
            f=1
        if d==2:
            break
        r=r+1
if d==2:
    print('YES')
else:
    print('NO')
