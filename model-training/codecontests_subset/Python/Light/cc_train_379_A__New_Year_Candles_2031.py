a,b=map(int,input().split())
sum=0
sum += a

while True:        
    c = a//b
    sum += c
    o = a%b
    c = c + o
    if (c < b):
        break
    else:
        a = c

print( sum )



      
