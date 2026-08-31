a,b = input().split()

a = int(a)
b = int(b)

add = a
x=0

while(True):
    c = a%b
    a = a//b
    a = a+c

    add+=(a-c)
    
    if(a<b):
        print(add)
        break


    

    

