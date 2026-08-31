x=input()
x=x.split()
a=[]
c=[]
d=[]
z=-1
yonax=0
for k in range (int(x[0])):
        y=input()
        y=y.split()
        if int(y[0])==0:
                yonax=yonax+1
        a.append(y)
if yonax==int(x[0]):
        print("NO")
else:
        for y in range (int(x[0])):
                for b in range (1,int(a[y][0])+1):
                        c.append(int(a[y][b]))
        
        numero=(len(c))
        c.sort(reverse= True)
        for s in range (numero):
                for z in range (s+1,numero):
                        if c[s]!=c[z]:
                                a=1
                        else:
                                a=0
                                break
                if a==1:
                        d.append(c[s])
        if len(d)==0:
                d.append(c[len(c)-1])
        else:
                if (c[len(c)-1])!= (d[len(d)-1]):
                        d.append(c[len(c)-1])        
        if len(d)==int(x[1]):
                print("YES")
        else:
                print("NO")