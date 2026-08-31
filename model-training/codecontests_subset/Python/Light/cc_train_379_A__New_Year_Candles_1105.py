x=input()
x=x.split()
x1=int(x[0])
x3=x1
x2=int(x[1])
flag=0
while x1>=x2:
    x1=x1-x2+1
    flag+=1
print(flag+x3)    
