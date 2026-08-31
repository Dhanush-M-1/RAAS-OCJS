n = int(input())

def isPossible(a,b):
    if(a>0 and b>1):
        return True
    return False
    
result = []
for x in range(n):
    a,b,c = [int (x) for x in input().split()]
    maxx = max(a,b,c)
    count = 0
    while(a>=1 and b>=2 or b>=1 and c>=2):
        maxx = max(a,b,c)
        if(maxx == b):
            if(isPossible(b,c)):
                b -= 1
                c -= 2
                count += 3
            elif(isPossible(a,b)):
                a -= 1
                b -= 2
                count += 3
        elif(maxx == c):
            if(isPossible(b,c)):
                b -= 1
                c -= 2
                count += 3
            elif(isPossible(a,b)):
                a -= 1
                b -= 2
                count += 3
        else:
            if(isPossible(b,c)):
                b -= 1
                c -= 2
                count += 3
            elif(isPossible(a,b)):
                a -= 1
                b -= 2
                count += 3
    result.append(count)

for x in result:
    print(x)
    
