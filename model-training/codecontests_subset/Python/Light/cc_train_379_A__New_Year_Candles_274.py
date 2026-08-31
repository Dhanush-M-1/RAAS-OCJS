
a,b=map(int,(input()).split())
temp: int=0
s=0
x=a
y=0
while a>=b:
    temp=int(a/b)
    s+=temp
    y=a%b
    a=temp+y
    if a==0:
        break
print(int(x+s))


1