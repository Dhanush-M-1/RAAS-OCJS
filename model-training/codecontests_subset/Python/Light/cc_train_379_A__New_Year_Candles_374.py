n=input().split()
a=int(n[0])
b=int(n[1])
s=a
while a>=b:
    
    n=divmod(a,b)
    s+=n[0]
    a=n[0]+n[1]
print(s)
