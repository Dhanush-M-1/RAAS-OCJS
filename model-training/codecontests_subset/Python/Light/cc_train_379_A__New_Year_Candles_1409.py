a,b=map(int,input().split())
h=a
while True:
    h+=a//b
    a=a//b+a%b 
    if a<b:
        break
print(h) 