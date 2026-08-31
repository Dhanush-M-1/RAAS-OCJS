ch=input()
L=[int(i)for i in ch.split(' ')]
n=L[0]
p=L[1]
w=L[2]
d=L[3]
p2=p
x=p2//w
y=(p2-(x*w))//d
Test=True
if w%d==0:
          Test=False
while Test==True:
          if (p2-(x*w))%d==0:
                    break
          x=x-1
          y=(p2-(x*w))//d
          if x<0:
                    break
          
          
z=n-x-y

if x<0:
          print(-1)
else:
          if z<0:
                    print(-1)
          else:
                    if (x*w)+(y*d)==p2:
                              print(x,y,z)
                    else:
                              print(-1)
