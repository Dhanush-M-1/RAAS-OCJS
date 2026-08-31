n=int(input())
s=input()
eight=0
other=0
for i in s:
    if i=='8':
        eight+=1
    else:
        other+=1
z=0
a= eight+other
while 0<eight and 0<a:
    eight-=1
    num=1
    while num<11 and 0<other:
        other-=1
        num+=1
    while num<11 and 0<eight:
        eight-=1
        num+=1
    if num==11:
        z+=1
    a=eight+other
print(z)