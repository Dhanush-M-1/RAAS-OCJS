def findmin(lcopy, toexceed):
    toex = ord(toexceed) - 97
    for each in lcopy[(toex+1):]:
        if each > 0:
            return True
    return False

def arrange(lcopy, toexceed = None):
    if toexceed is None:
        ans = ""
        for i in range(26):
            ans += chr(i+97)*lcopy[i]
        return ans

    ans = ""
    for i in range(ord(toexceed)-97+1, 26):
        if lcopy[i] > 0:
            ans += chr(i+97)
            lcopy[i] -= 1
            break

    return ans + arrange(lcopy)


def operation(s1, s2):
    first_count = [0]*26
    for letter in s1:
        first_count[ord(letter)-97] += 1

    common = 0
    lcopy = list(first_count)
    for i in range(len(s2)):
        letter = s2[i]
        num = ord(letter) - 97
        if lcopy[num] > 0:
            lcopy[num] -= 1
            common += 1
        else:
            break

    found = False
    ans = ""
    #print(common)
    for cval in range(common, -1, -1):
        #print(cval)
        if cval >= len(s1):
            lcopy[ord(s2[cval-1])-97] += 1
            continue
        else:
            if cval == len(s2):
                found = True
                ans = s2[:cval] + arrange(lcopy)
                break
            else:
                #print("yo", s2[cval])
                if findmin(lcopy, s2[cval]):
                    found = True
                    ans = s2[:cval] + arrange(lcopy, s2[cval])
                    break
                else:
                    lcopy[ord(s2[cval-1])-97] += 1

    if not found:
        return -1
    else:
        return ans

s1 = input()
s2 = input()
print(operation(s1, s2))
