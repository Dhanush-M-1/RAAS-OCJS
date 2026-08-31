n = int(input())
str = list(input())
dict = {}
for i in range(0, 26):
    dict[chr(97+i)] = 0
#print(str)
for c in str:
    dict[c] += 1
for i in range(0, 26):
    if dict[chr(97 + i)]%n != 0:
        print(-1)
        exit(0)
dict2 = {}
for i in range(0, 26):
    dict2[chr(97+i)] = 0
for i in range(0, 26):
    dict2[chr(97+i)] = dict[chr(97+i)] // n
ansString = []
while dict[str[0]] > 0:
    for i in range(0, 26):
        for j in range(0, dict2[chr(97+i)]):
            ansString.append(chr(97+i))
        dict[chr(97+i)] -= dict2[chr(97+i)]
for character in ansString:
    print(character, end="")
