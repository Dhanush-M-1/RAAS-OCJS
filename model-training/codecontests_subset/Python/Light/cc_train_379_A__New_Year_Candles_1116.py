a,b=map(int,input().split())
time=a
c=a
d=0

while c>=b:
    
    d=c%b
    c=c//b
    
    time=time+c
    c=c+d
print(time)    