a=input()


y=0
h=0
g=0
for i in range(int(input())):
    t=input()
    if t==a:
        print('YES')
        g+=1
        break
    else:
        if a[0] in t:
            if t[1]==a[0]:
                y+=1
        if a[1] in t:
            if t[0]==a[1]:
                h+=1
if g==0:
    if min(y,h)>=1:
        print('YES')
    else:
        print('NO')
        
