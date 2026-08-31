a,b=list(map(int,input().split()))
n=a

while a //b!=0:
    n+=a//b
    a=a//b+a%b
print(n)
    
    
