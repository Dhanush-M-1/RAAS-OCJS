# cook your dish here
t = int(input())
while t:
    n = int(input())
    n1 = n
    n2 = n
    k1 = 0
    k2 = 0 
    while n1/3 == int(n1/3):
        n1 = n1//3
        k1 = k1+1
    while n2/2 == int(n2/2):
        n2 = n2//2
        k2 = k2+1
    if n==1:
        print('0')
    else:
        if (2**k2)*(3**k1)== n:
            if k1>k2:
                print(k1+k1-k2)
            if (k1==k2):
                print(k1)
            if k1<k2:
                print('-1')
        else:
            print('-1')
            
        
    t =t -1