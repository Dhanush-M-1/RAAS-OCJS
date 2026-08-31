s=input('')
s1=input('')
s2=input('')
r1,r2=s.split(' ')
r1=int(r1)
r2=int(r2)
c1,c2=s1.split(' ')
c1=int(c1)
c2=int(c2)
d1,d2=s2.split(' ')
d1=int(d1)
d2=int(d2)
a=(2*r1-r2+2*c1-c2+2*d1-d2)/6
b=(2*r1-r2+2*c1+5*c2-4*d1-d2)/6
c=(-4*r1-r2+2*c1-c2+2*d1+5*d2)/6
d=(2*r1+5*r2-4*c1-c2+2*d1-d2)/6
# print(a,b,c,d)
l=[1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0]
l1=[]
if(a not in l1):
    l1.append(a)
if(b not in l1):
    l1.append(b)
if(c not in l1):
    l1.append(c)
if(d not in l1):
    l1.append(d)
if(a in l and b in l and c in l and d in l):
    if(len(l1)==4):
        print(int(a),int(b),end='\n')
        print(int(c),int(d))
    else:
        print('-1')
else:
    print('-1')
