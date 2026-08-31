s=input()
a=int(s.split()[0])
b=int(s.split()[1])
x=0
result=a
while a>0:
    x+=a%b
    a//=b
    result+=a
    if a==0 and x>=b:
        a=x
        x=0
'''while x>0:
    x//=b
    result+=x'''
print(result)    
