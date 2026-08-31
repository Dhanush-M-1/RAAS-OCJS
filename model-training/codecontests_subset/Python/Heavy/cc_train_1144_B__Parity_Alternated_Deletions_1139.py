if __name__ == "__main__":

    n = int(input())
    inp = input()
    even, odd = [], []

    numbers = inp.split(' ')
    for number in numbers:
        number = int(number)
        if number % 2 == 0:
            even.append(number)
        else:
            odd.append(number)

    diff = abs(len(even) - len(odd))
    if diff <= 1:
        print(0)
    else:
        sum = 0
        even.sort()
        odd.sort()

        if len(even)>len(odd):
            for i in reversed(range(diff-1)):
                sum+= even[i]
        else:
            for i in reversed(range(diff-1)):
                sum += odd[i]
        print(sum)