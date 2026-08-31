from sys import stdin
import pprint

input_string = list(map(int,stdin.readline().split()))

mediana = input_string[1]

array = list(map(int,stdin.readline().split()))

array.sort()
change = 0


if array[array.__len__() // 2] > mediana:

    for i in range(0, (array.__len__() // 2) + 1):
        if array[i] > mediana:
            change += array[i] - mediana

elif array[array.__len__() // 2] < mediana:

    for i in range(array.__len__() // 2, array.__len__()):

        if array[i] < mediana:
            change += mediana - array[i]


print(change)



