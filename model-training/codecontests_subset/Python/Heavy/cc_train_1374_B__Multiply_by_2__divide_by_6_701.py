def MultiplyandDivide(n):
    
    doses = 0
    treses = 0
    
    while n > 1:
        if n%2 == 0:
            n /= 2
            doses += 1
        elif n%3 == 0:
            n /= 3
            treses += 1
        else:
            return -1
    
    if doses > treses:
        return -1
    
    else:
        return treses + (treses-doses)
    
        
Lista = []

total = int(input())

for i in range(total):
    Lista.append(int(input()))
    
for j in Lista:
    print(MultiplyandDivide(j))
