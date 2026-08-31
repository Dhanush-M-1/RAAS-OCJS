s=input().split()
a=int(s[0])
b=int(s[1])
f=0
ost=a
k=a
while ost//b>=1 :
    f=ost//b
    ost=ost-(b*f)
    k=k+f
    ost=ost+f
print(k)
    
    
