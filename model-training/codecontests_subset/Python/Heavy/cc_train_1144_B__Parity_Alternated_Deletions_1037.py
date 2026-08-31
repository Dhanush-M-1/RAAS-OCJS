qtd = int(input())
elements = list(map(int, input().split()))

evenElements = sorted(list(filter(lambda x: not x % 2, elements)), reverse = True)
oddElements = sorted(list(filter(lambda x: x % 2, elements)), reverse = True)

if(len(evenElements) > len(oddElements)):
    evenElements.pop(0)
    getOdd = True
    getEven = False
else:
    oddElements.pop(0)
    getOdd = False
    getEven = True

while(len(evenElements) and len(oddElements)):
    if(getEven and len(evenElements)):
        evenElements.pop(0)
        getOdd = True
        getEven = False
    elif(getOdd and len(oddElements)):
        oddElements.pop(0)
        getOdd = False
        getEven = True

if(getEven and len(evenElements)):
    evenElements.pop(0)
elif(getOdd and len(oddElements)):
    oddElements.pop(0)

print(sum(evenElements) + sum(oddElements))
