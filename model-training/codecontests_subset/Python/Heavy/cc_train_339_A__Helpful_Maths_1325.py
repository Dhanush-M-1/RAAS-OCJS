# Variables
s = input()
arrange = []
newArrange = []
one = 0
two = 0
three = 0
finalString = ""

# Loops
for i in s:
    if i != "+":   
        arrange.append(int(i))

for i in arrange:
    if i == 1:
       one += 1
    if i == 2:
       two += 1
    if i == 3:
       three += 1 

for i in range(one):
    newArrange.append(1)
for i in range(two):
    newArrange.append(2)
for i in range(three):
    newArrange.append(3)

f = 0

for i in newArrange:
    finalString += str(i)
    if f < len(newArrange) - 1:
        finalString += "+"
    f += 1

# Answer
print(finalString)
    
