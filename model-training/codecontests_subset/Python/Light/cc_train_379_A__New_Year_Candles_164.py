a,b=input().split()
a=int(a)
b=int(b)
noofhours=a
while a>=b:
     d=a//b;
     noofhours=noofhours+d
     a=a//b+a%b
print(noofhours)
