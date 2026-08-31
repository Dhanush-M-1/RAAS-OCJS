txt=input()
a,b=txt.split(" ")
a=int(a)
b=int(b)
total=a
left=0
while True:
    add=0
    left+=a%b
    if left>=b:
        add=1
        left=left%b
    if a<b and add!=1:
        break
    a=a//b
    a+=add
    total+=a
print(total)