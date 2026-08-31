def replace(input, inputs):
    afind = inputs.find(" ")
    a = inputs[0:afind]
    inputs = inputs[afind + 1:]

    b = inputs[0:]

    afind = input.find(" ")
    a1 = input[0:afind]
    input = input[afind + 1:]

    b1 = input[0:]

    if a1 == a:
        a1 = b
    else:
        b1 = b

    return a1+" "+b1

array = []
array.append(input(""))
num = int(input(""))
for x in range(0,num):
    stuff = input("")
    array.append(stuff)

print(array[0])
for x in range(0,len(array)):
    if x+1 != len(array):
        array[x+1]= replace(array[x], array[x+1])
        print(array[x+1])