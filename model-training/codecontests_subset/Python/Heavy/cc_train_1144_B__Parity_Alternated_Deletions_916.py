
num = int(input().strip())
array = list(map(int,input().strip().split()))
array1 = sorted(array,reverse = True)
array2 = [i for i in array1]
even = True
while True:
    
    stop = True
    for i in range(len(array1)):
        if array1[i] % 2 == 0:
            if even:
                array1.pop(i)
                stop = False
                break
        else:
            if not even:
                array1.pop(i)
                stop = False
                break
    if even:
        even = False
    else:
        even = True

    if array1 == [] or stop:
        break
even = False
while True:
    
    stop = True
    for i in range(len(array2)):
        if array2[i] % 2 == 0:
            if even:
                array2.pop(i)
                stop = False
                break
        else:
            if not even:
                array2.pop(i)
                stop = False
                break
    if even:
        even = False
    else:
        even = True

    if array2 == [] or stop:
        break
print(min(sum(array1),sum(array2)))
