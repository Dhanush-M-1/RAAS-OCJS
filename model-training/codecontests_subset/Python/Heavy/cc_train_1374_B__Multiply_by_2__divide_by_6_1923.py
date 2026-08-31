def conver(m, n): 
  
    if(m == n): 
        return 0
  
    # only way is to do 
    # -1(m - n): times 
    if(m > n): 
        return m - n 
  
    # not possible 
    if(m < 1 and n > 0): 
        return -1
  
    # n is greater and n is odd 
    if(n % 2 == 1): 
  
        # perform '-1' on m 
        #(or +1 on n): 
        return 1 + conver(m, n * 2) 
  
    # n is even 
    else: 
          
        # perform '*2' on m 
        #(or n/2 on n): 
        return 1 + conver(m, n / 6) 
t=int(input())
for i in range(t):
    n=int(input())
    x=conver(1,n)
    if type(x)!=int:
        print(-1)
    else:
        print(x)