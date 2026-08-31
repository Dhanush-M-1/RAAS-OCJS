a,b=map(int,input().split(" "))
h=a
while(a>=b):
    c=a%b
    a=a//b 
    h+=a
    a+=c
print(h)