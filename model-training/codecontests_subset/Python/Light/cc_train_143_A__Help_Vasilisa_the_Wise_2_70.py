m=input()
n=input()
o=input()
r1,r2=m.split(" ")
c1,c2=n.split(" ")
d1,d2=o.split(" ")
x=int((int(r1)+int(d1)-int(c2))/2)
w=int((int(r2)+int(d2)-int(c2))/2)
y=int((int(r1)+int(d2)-int(c1))/2)
z=int((int(r2)+int(d1)-int(c1))/2) 
a=int(r1)+int(r2)
b=int(c1)+int(c2)
c=int(d1)+int(d2)
if x==y or y==z or z==w or w==x or y==w or x==z:
    print(-1)
elif x>9 or y>9 or w>9 or z>9 or x<1 or y<1 or w<1 or z<1:
    print(-1)
elif a!=b or b!=c or c!=a:
    print(-1)
else:
    print(str(x)+" "+str(y))
    print(str(w)+" "+str(z))


