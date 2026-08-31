t = input()

def isPal(s):
    return s == s[::-1] and s[0] != '!'

for test in range(int(t)):
    s = list(input())
    count = 0

    if len(s) == 1:
        print(0)
    elif len(s) == 2:
        if isPal(s):
            print(1)
        else:
            print(0)
    else:
        if s[1] == s[0]:
            count = count + 1
            s[1] = '!'

        for i in range(len(s)-2):
            j = i + 2
            if isPal(s[j-1:j+1]) or isPal(s[j-2:j+1]):
                count = count + 1
                s[j] = '!'

        print(count)
