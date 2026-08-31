line1 = input("").split()
nButtons = int(line1[0])
nBulbs = int(line1[1])
listOfBulbsByNum = []
result = True
for i in range(nButtons):
    listOfBulbsByNum.extend(input("").split()[1:])
for i in range(1,nBulbs+1):
    if str(i) not in listOfBulbsByNum:
        result = False
if result == False:
    print("NO")
else:
    print("YES")