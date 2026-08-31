n = int(input())
matches = n* (n-1)
dress = []
for i in range(n):
    h, g = list(map(int,input().split()))
    dress.append(h)
    dress.append(g)

def fromFirst():
    change = 0
    i = 0
    j = 0
    while(j<len(dress)):
        if(i == j):
            j += 3
            if(dress[i] == dress[j]):
                change += 1
                j+= 2
            else:
                j+= 2
        else:
            if(dress[i] == dress[j]):
                change += 1
                j += 2
            else:
                j += 2

    return change


def afterFirst():
    change = 0
    for i in range(2,len(dress), 2):
        if((len(dress) - 1) - i == 1):
            j = 0
            j = i-1
            if(j != 0):
                while(j>0):
                    if(dress[i] == dress[j]):
                        change += 1
                        j -= 2
                    else:
                        j -= 2
            else:
                return change
        else:
            j = 0
            while(j<len(dress)):
                if(j == 0):
                    j += 1
                    if(dress[i] == dress[j]):
                        change += 1
                        j += 2
                    else:
                        j += 2
                else:
                    if(dress[i] == dress[j]):
                        change += 1
                        j += 2
                    else:
                        j += 2

    return change


print(fromFirst() + afterFirst())

                    
