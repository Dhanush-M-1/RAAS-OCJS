x = int(input())

for _ in range(x):
    n = int(input())

    broken = False
    count = 0
    while n != 1:
        if n == 2:
            broken = True
            break
        elif n%2 == 0 and n%6 != 0:
            broken = True
            break
        elif n%6 == 0:
            n = n//6
            count += 1
        else:
            n *= 2
            count += 1

    if (broken == True):
        print("-1")
    else:
        print(count)




'''def countways(n): 
    if (n == 1): 
        return 0
    elif (n % 6 == 0): 
        return 1 + countways(n / 6)
    else: 
        return 1 + countways(n * 2)

# Driver code
x = int(input())
for _ in range(x):
    n = int(input())
    try:
        print(countways(n))
    except:
        print("-1")'''