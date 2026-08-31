def fibonacci(a,b,n): 
    if n < 0: 
        print("Incorrect input") 
    elif n == 0: 
        return a 
    elif n == 1: 
        return b
    elif n==2:
        return a^b
    else: 
        for i in range(b,n): 
            c = a ^ b 
            a = b 
            b = c 
        return b

n=int(input())

for i in range(0,n):
    a,b,n=map(int,input().split(' '))
    c=a^b
    if b^c==a:
        t=n%3
        if t==0:
            print(a)
        elif t==1:
            print(b)
        elif t==2:
            print(c)
    else:
        print(fibonacci(a,b,n))
    
       
'''

def fibonacci(FibArray,n): 
    if n<0: 
        print("Incorrect input") 
    elif n<=len(FibArray): 
        return FibArray[n-1] 
    else: 
        temp_fib = fibonacci(FibArray,n-1)+fibonacci(FibArray,n-2) 
        FibArray.append(temp_fib) 
        return temp_fib 
  







n=int(input())

for i in range(0,n):
    
    a,b,n=map(int,input().split(' '))
    
    
    
    
    print(fibonacci(n))
    

   ''' 
