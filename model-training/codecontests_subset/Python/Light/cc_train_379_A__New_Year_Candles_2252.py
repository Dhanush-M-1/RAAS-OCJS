a,b=input ().split(' ')
a,b=int(a),int(b)
n=a
a=a+(n//b)
while(1):
    n=(n//b)+(n%b)
    if((n)>=b):
        a=a+(n//b)
    else:
        break
print(a)