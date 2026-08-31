count = int(input())
array = list(map(int, input().split()))
n = 0
for elem in array:
    if elem % 2 == 0:
        n +=1
count1 = count // 2
array1 = list()
array2 = list()
s1 = 0
s2 = 0
for elem in range(count):
    if (elem + 1) in array:
        for elem1 in range(count):
            if (not (elem1 + 1 in array1)) and (elem1 % 2 == 0):
                array1.append(elem1 + 1)
                s1 = s1 + abs(elem1 - elem)
                break
        for elem1 in range(count):
            if (not (elem1 + 1 in array2)) and (elem1 % 2 == 1):
                array2.append(elem1 + 1)
                s2 = s2 + abs(elem1 - elem)
                break
print(min(s1, s2))