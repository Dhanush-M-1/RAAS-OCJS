def isAValidString(letterMap, k):
    for letter in letterMap.keys():
        if letterMap[letter] % k != 0:
           return False
    return True

def availableLettersForSubstrings(letterMap, k):
    availableLetters = {}
    for letter in letterMap.keys():
        availableLetters[letter] = int(letterMap[letter] / k)
    return availableLetters

k = int(input())
s = input()

letterMap = {}
for letter in list(s):
    if letter not in letterMap.keys():
        letterMap[letter] = 1
    else:
        letterMap[letter] += 1

if isAValidString(letterMap, k):
    availableLetters = availableLettersForSubstrings(letterMap,k)
    oneString = ""
    for letter in availableLetters.keys():
        i = 0
        while i < availableLetters[letter]:
            oneString += letter
            i += 1
    result = ""
    i = 0
    while i < k:
        result += oneString
        i += 1
    print(result)
else:
    print(str(-1))

 	 		   	 				  	   		   						