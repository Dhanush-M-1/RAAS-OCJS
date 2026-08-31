m=input().split(' ')
a=int(m[0])
b=int(m[1])
ch=0
po=0
while a>0:
    ch+=1
    po+=1
    a-=1
    if po==b:
        po=0
        a+=1
print(ch)