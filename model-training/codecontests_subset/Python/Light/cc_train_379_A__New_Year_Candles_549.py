a=input()
b=a.split()
for i in range(len(b)):
    b[i]=int(b[i])
d=b[0]
f=b[1]
while b[0]>=b[1]:
    e=b[0]//b[1]
    f=b[0]%b[1]
    b[0]=e+f
    d+=e
print(d)