a=int(input())
b=input()
c=""
d=0
for i in range(len(b)):
    if(b[i]=='8'):
        d+=1
e=a//11
if(d>=e):
    print(e)
else:
    print(d)
