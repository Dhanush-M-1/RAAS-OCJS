ch=input("")
l=ch.split()
y=int(l[-1])
while 1:
    ch2=input("")
    l2=ch2.split()
    if len(l2)==int(l[0]):
        break
c=100
for i in range (0,int(l[0])):
    x=int(l2[i])
    if (y%x==0):
        m=y/x
        if (m<c):
            c=m
print(round(c))
