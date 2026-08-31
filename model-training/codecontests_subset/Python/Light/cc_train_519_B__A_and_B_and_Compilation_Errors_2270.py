def findError(first, second) :
    i = 0
    j = 0
    for j in range(len(second)) :
        if first[i] != second[j] :
            return first[i]
        i += 1
    return first[i]

n = int(input())
first = sorted([int(i) for i in input().split()])
second = sorted([int(i) for i in input().split()])
third = sorted([int(i) for i in input().split()])
print(findError(first, second))
print(findError(second, third))