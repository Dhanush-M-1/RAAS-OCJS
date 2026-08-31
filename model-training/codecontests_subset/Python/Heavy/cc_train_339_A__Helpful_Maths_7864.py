s = input()
x1 = 0
x2 = 0
x3 = 0
for i in range(len(s)):
    if s[i] == "1":
        x1 += 1
    if s[i] == "2":
        x2 += 1
    if s[i] == "3":
        x3 += 1
if x1 != 0:
    print(1 , end = "")
    for i in range(x1 - 1):
        print("+1" , end = "")
    for i in range(x2):
        print("+2" , end = "")
    for i in range(x3):
        print("+3" , end = "")
elif x2 != 0:
    print(2 , end = "")
    for i in range(x2 - 1):
        print("+2" , end = "")
    for i in range(x3):
        print("+3" , end = "")
elif x3 != 0:
    print(3 , end = "")
    for i in range(x3 - 1):
        print("+3" , end = "")
