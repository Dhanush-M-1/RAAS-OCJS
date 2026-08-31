import sys

k = int(input())
string = input()

letterList = []
numberofLetter = []
letterFinal = []
jawaban = []

for letter in string:
    if letter in letterList:
        continue
    else:
        letterList.append(letter)
for letter2 in letterList:
    numberofLetter.append(string.count(letter2)) 
for counts in numberofLetter:
    if float(counts/k).is_integer():
        letterFinal.append(counts/k)
    else:
        print("-1")
        sys.exit()
        
for i in range(k):
    for idx, val in enumerate(letterList):
        for _ in range(int(letterFinal[idx])):
            jawaban.append(val)

final = ''.join(jawaban)
print(final)
