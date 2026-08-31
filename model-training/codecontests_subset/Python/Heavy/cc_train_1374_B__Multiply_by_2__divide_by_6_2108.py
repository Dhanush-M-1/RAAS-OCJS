t = int(input())



import math
def primeFactors(n): 
    f= False
    ans=[]
    two = 0
    three= 0
    while n % 2 == 0: 
        f = True 
        n = n / 2
        two+=1
    if(f):
        ans.append(2)
    while n%3 == 0:
        c = True
        n= n/3
        three+=1
    a = [two,three]

    if(n==1):
        return a
    else:
        return -1
          




def func(n):
    
       
    a = primeFactors(n)
    twos=0
    threes=0
    #print(a)
    if(a== -1 ):
        return -1
    else:
        if(a[0]>a[1]):
            return -1
        else:
            return (2*a[1] - a[0])



'''

    for j in a:
        if(j==2):
            twos+=1
        elif(j==3):
            threes+=1
        else:
            return -1
    #print(twos,threes)

    if(twos>threes):
        return -1
    else:
        return (2*threes-twos)
'''

for i in range(t):
    n = int(input())
    print(func(n))



































    


