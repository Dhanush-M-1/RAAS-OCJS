s=input()
a=b=c=d=0
for i in range(len(s)):
    if s[i]=='1':
        a+=1
    elif s[i]=='2':
        b+=1
    elif s[i]=='3':
        c+=1
    else:
        d+=1
    i+=1
while True:
    if a==0:
        break
    print(str(1),end="")
    a-=1
    if d!=0:
        print('+',end="")
        d-=1
while True:
    if b==0:
        break
    print(str(2),end="")
    b-=1
    if d!=0:
        print('+',end="")
        d-=1
while True:
    if c==0:
        break
    print(str(3),end="")
    c-=1
    if d!=0:
        print('+',end="")
        d-=1