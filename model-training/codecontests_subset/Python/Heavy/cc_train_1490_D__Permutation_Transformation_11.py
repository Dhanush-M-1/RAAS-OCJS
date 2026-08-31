def calculation(length, values, x):
    if length == 0:
        return []
    if length == 1:
        return [x]
    maximum = values.index(max(values))
    first = values[:maximum]
    last = values[maximum + 1:]
    return calculation(len(first), first, x + 1) + [x] + calculation(len(last), last, x + 1)

def main():
    number = int(input())
    for i in range(number):
        cont = 0
        values = []
        length_permutation = int(input())
        input_values = input().split(" ")
        for i in input_values:
            values.append(int(i))

        result = calculation(length_permutation, values, cont)
        
        for i in range(len(result) - 1):
            print(result[i], end=' ')
        print(result[len(result) - 1])

if __name__ == '__main__':
    main()