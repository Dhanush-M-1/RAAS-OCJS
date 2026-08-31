a=input()
x=0
y=0
z=''
b='+'
while len(a)<=100 and x<=(len(a)-1):
    if int(a[x])==1:
        if len(z)==(len(a)-1):
            b=''
        z=z+str(a[x])+b
        
    x=x+2
    
x=0
while len(a)<=100 and x<=(len(a)-1):
    if int(a[x])==2:
        if len(z)==(len(a)-1):
            b=''
        z=z+str(a[x])+b
        x=x+2
    else:
        x=x+2
x=0
while len(a)<=100 and x<=(len(a)-1):
    if int(a[x])==3:
        if len(z)==(len(a)-1):
            b=''
        z=z+str(a[x])+b
        x=x+2
    else:
        x=x+2
print(z)
