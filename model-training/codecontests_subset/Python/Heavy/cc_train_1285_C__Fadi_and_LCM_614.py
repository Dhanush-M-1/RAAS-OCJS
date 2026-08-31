import math

def main():
    prime = []
    n = int(input())
    if n == 2:
        print(1, 2)
        return
    x = n
    two = 1
    while x % 2 == 0:
        x = x / 2
        two = two * 2
    prime.append(two)
        
    for i in range (3, int(math.floor(math.sqrt(n)))+1, 2):
        temp = 1
        while x % i == 0:
            x = x / i
            temp = temp * i
        if temp != 1:
            prime.append(temp)
        if i > x:
            break
    if x > 1:
        prime.append(x)
    previous = 1
    min = 1000000000000
    ansa = 1
    ansb = 1
    for i in range(int(math.pow(2,len(prime)))):
        a = 1
        b = 1
        j = 1
        x = i
        for value in prime:
            if (x - math.pow(2,j -1)) % math.pow(2, j) == 0:
                a = a * value
                x = x - math.pow(2,j -1)
            else:
                b = b * value
            j = j +1
        if min > max(a,b):
            ansa = a
            ansb = b
            min = max(a,b)
        
    print (int(ansa),int(ansb))

main()
        