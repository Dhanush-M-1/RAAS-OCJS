test_cases = int(input())
operations = []
for i in range(test_cases):
    input()
    operations.append(input())
for operation in operations:
    left = 0
    right = 0
    if (operation[0] == '>' or operation[-1] == '<'):
        print('0')
    else:
        for character in operation:
            if character != '>':
                left += 1
            else:
                break
        for i in range(len(operation)-1, -1 ,-1):
            if operation[i] != '<':
                right += 1
            else:
                break
        print(min(left, right))
