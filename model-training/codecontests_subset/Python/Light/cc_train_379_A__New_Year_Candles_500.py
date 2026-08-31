a, b = [int(x) for x in input().split( )] 

count=a

summing=0

while (a>=b):
    summing+=a//b
    a=a//b+a%b
    
print (count+summing)