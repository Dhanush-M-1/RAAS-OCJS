phonePass = input()
numOfWords = int(input())
knownWords = []
flag = False
m1 = False
m2 = False
for i in range(numOfWords):
    s = input()
    knownWords.append(s)

for i in range(numOfWords):
    if (knownWords[i] == phonePass):
        flag = True

for i in range(numOfWords):
    if (knownWords[i][0] == phonePass[1]):
        m1 = True
    if (knownWords[i][1] == phonePass[0]):
        m2 = True
    if (m1 and m2):
        flag = True
if (not flag):
    print("NO")
else:
    print("YES")