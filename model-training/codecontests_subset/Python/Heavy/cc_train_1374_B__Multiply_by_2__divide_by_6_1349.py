import os
# from collections import Counter
is_dev = 'vscode' in os.environ

if is_dev:
    inF = open('in.txt', 'r')
    outF = open('out.txt', 'w')

def ins(r):
    return list(map(int, r.split(' ')))

def inputT():
    if is_dev:
        return inF.readline()
    else:
        return input()

def printT(data=''):
    if is_dev:
        return outF.write(str(data)+'\n')
    else:
        return print(data)


    
    
# Main:
# # Q3
# for _ in range(int(inputT())):
#     n = int(inputT())
#     printT(-1)



# Q2
from collections import Counter
import math
def primeFactors(n): 
    
    while n % 6 == 0:
        yield 3
        yield 2
        n = n //6
    
    while n % 2 == 0:
        yield 2
        n = n // 2
    
    while n % 3 == 0:
        yield 3
        n = n // 3
    
    if n > 1:
        raise ValueError('Not possible') 
    
#     math.log(n, 3)
    
    
#     # Print the number of two's that divide n 
#     while n % 2 == 0: 
#         yield 2
#         n = n / 2
          
#     # n must be odd at this point 
#     # so a skip of 2 ( i = i + 2) can be used 
#     for i in range(3,int(math.sqrt(n))+1,2): 
          
#         # while i divides n , print i ad divide n 
#         while n % i== 0: 
#             yield i
#             n = n / i 
              
#     # Condition if n is a prime 
#     # number greater than 2 
#     if n > 2: 
#         yield n 
        
for _ in range(int(inputT())):
    n = int(inputT())

    if n == 1:
        printT(0)
        continue
    
    
    # find prime factors 
    try:
        pf_list = list(primeFactors(n))
    except ValueError:
        printT(-1)
        continue
    pf_c = Counter(pf_list)
#     print(pf_list)
    # if prime factors contains only 3 and 2 and # of 2 >= # of 3:
    if 3 not in pf_c:
        pf_c[3] = 0
    if 2 not in pf_c:
        pf_c[2] = 0
    if set(pf_c.keys()) == {3,2} and pf_c[2] <= pf_c[3]:
        printT((pf_c[3] - pf_c[2])*2 + pf_c[2])
    else:
        printT(-1)


# Q1
# for _ in range(int(inputT())):
#     x,y,n = ins(inputT())
    
#     remainder_of_n = (n // x) * x + y
    
#     if remainder_of_n <= n:
#         printT(remainder_of_n)
#     else:
#         printT(remainder_of_n - x)
    
    
    
if is_dev:
    outF.close()
    print(open('out.txt', 'r').read() == open('outactual.txt', 'r').read())
