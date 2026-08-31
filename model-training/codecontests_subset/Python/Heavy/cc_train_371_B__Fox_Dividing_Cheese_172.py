a,b = input().split()

a = int(a)
b = int(b)

if a == b:
    print(0)
else:

    a2 = 0
    a3 = 0
    a5 = 0

    b2 = 0
    b3 = 0
    b5 = 0
    while(a%2 == 0):
        a2+=1
        a/=2
    while(a%3 == 0):
        a3+=1
        a/=3
    while(a%5 == 0):
        a5+=1
        a/=5
        
    while(b%2 == 0):
        b2+=1
        b/=2
    while(b%3 == 0):
        b3+=1
        b/=3
    while(b%5 == 0):
        b5+=1
        b/=5

    #print(a2,a3,a5 , b2,b3,b5)

    if a != b:
        print(-1)
    else:
        print(abs(a2-b2)+abs(a3-b3)+abs(a5-b5))

    
        
