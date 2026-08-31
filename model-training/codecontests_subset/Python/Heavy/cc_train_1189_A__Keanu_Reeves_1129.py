def isEven(s):
    zeroCount = 0
    for char in s:
        if char == '0':
            zeroCount += 1
        else:
            zeroCount -= 1
    return zeroCount == 0

def evenStrings(s):
    if len(s) % 2 != 0 or not isEven(s):
        return [s]
    if (len(s) // 2) % 2 != 0:
        return [s[:(len(s) // 2)], s[(len(s) // 2):]]
    else:
        return [s[:(len(s) // 2) - 1], s[(len(s) // 2) - 1:]]
    
n = int(input())
s = input()

result = evenStrings(s)

print(len(result))
print(" ".join(list(map(str, result))))
    