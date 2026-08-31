nStr = input()
n = int(nStr)

aStr = input()
bStr = input()
cStr = input()

aList = aStr.split()
bList = bStr.split()
cList = cStr.split()

aList.sort()
bList.sort()
cList.sort()

'''
print(aList)
print(bList)
print(cList)
'''

k1 = None
k2 = None

for i in range(len(bList)):
	if bList[i]!=aList[i]:
		k1 = aList[i]
		break
	elif i==len(bList)-1:
		k1 = aList[i+1]
		
for i in range(len(cList)):
	if cList[i]!=bList[i]:
		k2 = bList[i]
		break
	elif i==len(cList)-1:
		k2 = bList[i+1]
		
print(k1)
print(k2)