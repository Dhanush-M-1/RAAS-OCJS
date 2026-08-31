from collections import Counter
from string import ascii_uppercase

t = int(input())
for _ in range(t):
    s, c =  input().split()
    s = list(s)
    count = Counter(s)
    swapMade = False
    for i in range(len(s)):
        count[s[i]] -= 1
        if i >= len(c):
            print("---")
            break
        if s[i] < c[i]:
            print("".join(s))
            break
        # if i == 2:
        #     print("swapMade val in i == 2", swapMade, s[i] < c[i], s[i], c[i])
        if swapMade and s[i] < c[i]:
            print("---")
            break
        swapChar = None
        if not swapMade:
            for char in ascii_uppercase:
                if char < c[i]:
                    if count[char] > 0:
                        swapChar = char
                        break
            if swapChar != None:
                curIndex = i + 1
                while curIndex < len(s) and s[curIndex] != swapChar:
                    curIndex += 1
                # print("i", i, "curIndex", curIndex, "swapchar", swapChar)
                s[i], s[curIndex] = s[curIndex], s[i]
                # print("here")
                print("".join(s))
                break
            elif s[i] != c[i] and count[c[i]] > 0:
                indices = [idx for idx in range(i + 1, len(s)) if s[idx] == c[i]]
                for index in indices:
                    s[i], s[index] = s[index], s[i]
                    if "".join(s) < c:
                        print("".join(s))
                        break
                    else:
                        s[i], s[index] = s[index], s[i]
                else:
                    print("---")
                    break
                break
        if s[i] != c[i]:
            print("---")
            break
    else:
        print("".join(s)) if len(c) > len(s) else print("---")