a,b=[int(x) for x in input().split()]
q=0
s=0
while a>0:
    s+=a
    q+=a
    a=q//b
    q%=b
print(s)
    
