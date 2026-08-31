#Rodolfo Martínez Guevara

#Fill array with only integers
def fillArray(operation, intArray):
    for value in operation:
        # print(value)
        if value != '+':
            # print(value)
            intArray.append(value)

#Create array with the right order of values
def modifyOperation(intArray, newOperation):
    for value in intArray:
        newOperation.append(value)
        newOperation.append('+')

def main():
    intArray = []
    newOperation = []
    operation = input()
    # print(operation)
    fillArray(operation, intArray)
    intArray.sort()
    modifyOperation(intArray, newOperation)
    newOperation.pop()
    # print(newOperation)
    # result = []
    # result.join(newOperation)
    # print(result)
    result = ''.join(newOperation)
    print(result)

main()
