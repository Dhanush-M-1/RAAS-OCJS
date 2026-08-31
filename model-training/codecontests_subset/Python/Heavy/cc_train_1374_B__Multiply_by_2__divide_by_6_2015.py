def get(n):
    
    
    if n == 1:
        return 0
    
    if n % 3 != 0:
        return -1
    
    l = 0 # 3 degree
    k = 0 # 2 degree
    
    n, r = divmod(n, 3)
    
    while r == 0:
        l+=1
        n, r = divmod(n, 3) 
        
    n = int(3*n+r)
    
    n, r  = divmod(n, 2)
    
    while r == 0:
        k+=1
        n, r  = divmod(n, 2)
        
    n = int(2*n+r)
    
    if n != 1:
#         print('Do not:', n)
        return -1
    
#     print('2**{} x 3**{}'.format(k, l))
    
    if k > l:
        return -1
    
    return 2*l-k
    
    
m = int(input())
for _ in range(m):
    n = int(input())
    print(get(n))
        