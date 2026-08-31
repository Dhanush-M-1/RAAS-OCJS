s= input()
s=s.split()
a=int(s[0])
b=int(s[1])
hr=a
j=a
while(True):
    if(j<b):
        break
    else:
        j=j-b+1
        hr=hr+1

print(hr)