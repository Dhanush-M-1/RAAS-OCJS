r1,r2=map(int,input().split(' '))
c1,c2=map(int,input().split(' '))
d1,d2=map(int,input().split(' '))

for a in range(1,10):
    for b in range(1,10):
        if(a==b):
            continue
        for c in range(1,10):
            if(a==c or b==c):
                continue
            for d in range(1,10):
                if(a==d or b==d or c==d):
                    continue
                chk1 = a+d==d1 and b+c==d2
                chk2 = a+b==r1 and c+d==r2
                chk3 = a+c==c1 and b+d==c2
                if(chk1 and chk2 and chk3):
                    print(a,b)
                    print(c,d)
                    exit()
print(-1)