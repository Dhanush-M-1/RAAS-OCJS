def aux(length, values, x):
    if length == 0:
        return []
    elif length == 1:
        return [x]
    else:
        maximum = values.index(max(values))
        first = values[:maximum]
        last = values[maximum + 1:]

        return aux(len(first), first, x + 1) + [x] + aux(len(last), last, x + 1)

def main():
    number = int(input())

    for i in range(number):
        cont = 0
        values = []
        length_permutation = int(input())
        input_values = input().split(" ")
        
        for i in input_values:
            values.append(int(i))
        result = aux(length_permutation, values, cont)

        output = ""
        for i in range(len(result)):
            output += str(result[i]) + " "
        print(output)

if __name__ == '__main__':
    main()