s=input()
s=s.split()
s=[int(x) for x in s]
a=s[0]
b=s[1]
i=0
while a>0:
    i=i+1
    a=a-1
    if i%b==0:
        a=a+1
print(i)
