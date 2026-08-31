string = [i for i in input()]


newstring = []

for a in string:
    if not a == '+':
        newstring.append(a)

head = 0
while True:
    for a in range(head ,len(newstring)):
        if newstring[head] > newstring[a]:
            temp = newstring[a]
            newstring[a] = newstring[head]
            newstring[head] = temp
    head +=1
    if head == len(newstring):
        break
printstring = str(newstring[0])

for a in range(1, len(newstring)):
    printstring = printstring + '+' + newstring[a]

print(printstring)
