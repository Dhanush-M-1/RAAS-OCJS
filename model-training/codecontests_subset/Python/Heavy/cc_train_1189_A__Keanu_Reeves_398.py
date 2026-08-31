n = int(input())
str = input()


def isGood(str):
    count0 = len([x for x in str if x == '0'])
    count1 = len([x for x in str if x == '1'])
    return count0 != count1

def isTwoParts(str):
    for i in range(0, len(str)-1):
        str1 =  str[0:(i+1)]
        str2 =  str[(i+1):len(str)]
        if isGood(str1) and isGood(str2):
            print(2)
            print(str1,str2)
            return True    

if isGood(str):
    print(1)
    print(str)
elif not isTwoParts(str):
    print(3)
    print(str[0:len(str)-2], str[len(str-2)], str[len(str-1)])