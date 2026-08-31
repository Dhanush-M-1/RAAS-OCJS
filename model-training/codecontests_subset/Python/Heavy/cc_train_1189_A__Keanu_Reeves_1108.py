t = int(input())
n = input()
ones = n.count('1'); zeros = n.count('0')
if ones != zeros:
    print('1')
    print(n)
else:
    first_half = n[:len(n)//2]
    second_half = n[len(n)//2:]

    ones_first = first_half.count('1'); zeros_first = first_half.count('0')
    ones_second = second_half.count('1'); zeros_second = second_half.count('0')

    if ones_first != zeros_first and ones_second != zeros_second:
        print('2')
        print(first_half, second_half)
    else:
        first_half=n[:len(n)//2+1]
        second_half = n[len(n)//2+1:]
        print('2')
        print(first_half, second_half)
