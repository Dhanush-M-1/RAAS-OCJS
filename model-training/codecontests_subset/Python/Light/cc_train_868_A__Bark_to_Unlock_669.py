key = input()
n = int(input())
lst = []
for i in range(n):
    lst.append(input())
firstChar = False
secondChar = False
for s in lst:
    if s == key:
        print("YES")
        exit()
    if s[1] == key[0]:
        firstChar = True
    if s[0] == key[1]:
        secondChar = True
if firstChar and secondChar:
    print("YES")
else:
    print("NO")