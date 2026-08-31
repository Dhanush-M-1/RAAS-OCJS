string = input()
c1 = 0
c2 = 0
c3 = 0

for char in string:
    if char == '1':
        c1 += 1
    if char == '2':
        c2 += 1
    if char == '3':
        c3 += 1

stringf = ""

for j in range(0,c1):
    if stringf == "":
        stringf += "1"
    else:
        stringf += "+1"

for k in range(0,c2):
    if stringf == "":
        stringf += "2"
    else:
        stringf += "+2"

for l in range(0,c3):
    if stringf == "":
        stringf += "3"
    else:
        stringf += "+3"

print (stringf)