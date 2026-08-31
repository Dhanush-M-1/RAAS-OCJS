"""
Problem: Remainder
Source: Codeforces
Difficulty: 1200
"""


def strtoint(string):
    try:
        integer = int(string)
        return integer
    except ValueError:
        print("Value not integer!")
        exit()


def inttostr(integer):
    try:
        string = str(integer)
        return string
    except ValueError:
        print("Value not string!")
        exit()


def power(base, ex):
    if ex == 1 or ex == 0:
        return 1
    else:
        return base * power(base, ex-1)


def tochararray(string):
    chars = []
    for char in string:
        chars.append(char)
    return chars


def getdiff(ary1, ary2):
    count = 0
    for i in range(0, len(ary1)):
        if ary1[i] != ary2[i]:
            count += 1
    return count


def getNonZero(ary):
    count = 0
    for i in ary:
        if i != "0":
            count += 1
    return count


inputVal = input('').split(' ')
n = strtoint(inputVal[0])

x = inttostr(pow(10, strtoint(inputVal[1])))
y = inttostr(pow(10, strtoint(inputVal[2])))

num = tochararray(input(''))

temp = []

for i in range(len(num) - len(y), len(num)):
    temp.append(num[i])

results = getdiff(temp, y)

temp.clear()

for i in range((len(num)-len(x)+1), (len(num)-len(y))):
    temp.append(num[i])

results += getNonZero(temp)

print(results)



