n = int(input())
ai = list(map(int,input().split()))
even = [i for i in ai if i%2 == 0]
odd = [i for i in ai if i%2 != 0]
even.sort()
odd.sort()

if (len(odd) > len(even)):
    leftoverelements = len(odd) - len(even) - 1

    minimize_sum = 0
    i = 0

    while (i < leftoverelements):
        minimize_sum += odd[i]
        i += 1

    print(minimize_sum)


elif (len(even) > len(odd)):
    leftoverelements = len(even) - len(odd) - 1

    minimize_sum = 0
    i = 0

    while (i < leftoverelements):
        minimize_sum += even[i]
        i += 1
    print(minimize_sum)

else:
    print(0)