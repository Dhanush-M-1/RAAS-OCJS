def gcd(x, y):
    while(y): 
        x, y = y, x % y 
    return x
    
result = 0
n = int(input())
swords = [int(i) for i in input().split()]
maxi = max(swords)
stolenTotal = 0
zeroes = 0
howManyCarried = []

for i in swords:
    if i!=maxi:
        stolenTotal += (maxi-i)
        howManyCarried.append(maxi-i)

if len(howManyCarried)==1:
    print(1,end=" ")
    print(howManyCarried[0])
elif len(howManyCarried)==0:
    print("0 0")
else:
    result = gcd(howManyCarried[0], howManyCarried[1])
    for i in range(2,len(howManyCarried),1):
        result = gcd(result, howManyCarried[i]) 
    print(stolenTotal//result, end=" ")
    print(result)