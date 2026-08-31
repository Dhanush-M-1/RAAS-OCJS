n,b=map(int,input().split())
if(b==1):
    print("You Enter A Bad Number Computer Will Compute For True!!")
if(b==0):
    print("You Enter A Bad Number Computer Will Have Errors!!")
p=n
e=0
n2=0
while(n//b>0):
    while(n>=b):
        p=p+(n//b)
        n2=(n//b)
        e=e+(n%b)
        n=n2
    e=e+(n%b)
    n=e
    e=0
print(p)
