for _ in range(int(input())):
    a=input()
    b=len(a)
    c,d=[],0
    if(b==1):
        print(0)
        continue
    for _ in range(b):
        c.append(0)
    if(a[0]==a[1]):
        c[1]=1
        d+=1
    for _ in range(2,b):
        if(c[_-2]==0 and a[_]==a[_-2]):
            c[_]=1
            d+=1
        if(c[_-2]==0 and a[_-1]==a[_-2] and c[_-1]==0):
            c[_-1]=1
            d+=1
    if(c[b-1]==0 and c[b-2]==0 and a[b-1]==a[b-2]):
        d+=1

    print(d)
# CodeBy:RahulMahajan
# CF:anonymous3107
# CC:anonymous0201
# CSES:rahulmahajan