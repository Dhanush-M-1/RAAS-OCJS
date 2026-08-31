# Parity Alternated Deletions

def parity():

    n = int(input())

    I = list(map(int, input().split(' ')))


    even = []
    odd = []

    for i in I:
        if i%2 == 0:
            even.append(i)
        if i%2 == 1:
            odd.append(i)

    if len(even) == len(odd)+ 1 or len(even) + 1 == len(odd) or len(even) == len(odd):
        return 0
    if len(even) < len(odd):
        odd = sorted(odd)
        diff = len(odd) - len(even)
        sum = 0
        for i in range(diff-1):
            sum += odd[i]
        return sum
    if len(even) > len(odd):
        even = sorted(even)
        diff = len(even) - len(odd)
        sum = 0
        for i in range(diff-1):
            sum += even[i]
        return sum

print(parity())