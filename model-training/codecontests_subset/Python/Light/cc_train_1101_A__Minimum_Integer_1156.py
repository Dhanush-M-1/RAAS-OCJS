'''x=int(input())
z=int(input())
d=1
for i in range(x-1):
    f=int(input())
    if z!=f:
        d+=1
    z=f
print(d)
a=int(input())
b=int(input())
c=int(input())
d=0
if a+b+c>d:
    d=a+b+c
if (a+b)*c>d:
    d=(a+b)*c
if a*(b+c)>d:
    d=a*(b+c)
if a*b*c>d:
    d=a*b*c
print(d)'''
x=int(input())
for i in range(x):
    i=input().split()
    if int(i[2])<int(i[0]):
        print(int(i[2]))
    else:
        print(int(i[2])+(int(i[2])*(int(i[1])//int(i[2]))))
        
