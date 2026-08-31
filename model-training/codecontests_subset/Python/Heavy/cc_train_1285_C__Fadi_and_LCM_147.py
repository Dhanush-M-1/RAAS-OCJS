import math
n = int(input())

def lcm(array , n):
    first , second = array[0] , array[1]
    lcms = (first*second)//math.gcd(first , second)
    if lcms == n: return 1
    else: return 0
    

minimum = 999999999999

answer = []
for i in range(1, int(n**0.5 + 1)):
    if n%i==0:
        if i**2 != n:        # This case needed for perfect squares example 16, 64 etc.
            maxs = max( i , n//i )
            curr = [i , n//i]
            if lcm( curr , n ) == 1:
                if maxs < minimum:  
                    minimum = maxs
                    answer = [i,n//i]
            
        
        else:
            maxs = max(i,i)
            curr = [i , i]
            if lcm( curr , n ) == 1:
                if maxs < minimum:  minimum = maxs
                answer = [i,i]  
for ele in answer:
    print(ele,end=' ')
    
