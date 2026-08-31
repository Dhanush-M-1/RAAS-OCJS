def makeIntegers(A):
    for elem in A:
        elem = int(elem)

def main():
    first_string = input()
    numbers = list(first_string.split('+'))

    makeIntegers(numbers)

    sortedNumbers = sorted(numbers)

    if(len(sortedNumbers) == 1):
        print(sortedNumbers[0])
        return
    else:
        answer_string = ''
        for i in range(0,len(sortedNumbers) - 1):
            answer_string = answer_string + str(sortedNumbers[i]) + '+'
        answer_string = answer_string + str(sortedNumbers[len(sortedNumbers) - 1])

    print(answer_string)



main()
