#/usr/bin/python3

# MC721A
# 03 de abril de 2020
# Rogério Meirelles - RA160245

n = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]
c = [int(x) for x in input().split()]

dictA = {}
dictB = {}
dictC = {}

for x in a:
    if x in dictA:
        dictA[x] += 1
    else:
        dictA[x] = 1

for x in b:
    if x in dictB:
        dictB[x] += 1
    else:
        dictB[x] = 1

for x in c:
    if x in dictC:
        dictC[x] += 1
    else:
        dictC[x] = 1

for x in a:
    if x not in dictB:
        print(x)
        break
    elif dictA[x] != dictB[x]:
        print(x)
        break

for x in b:
    if x not in dictC:
        print(x)
        break
    elif dictB[x] != dictC[x]:
        print(x)
        break

			  		 		 			  		 	 			   		