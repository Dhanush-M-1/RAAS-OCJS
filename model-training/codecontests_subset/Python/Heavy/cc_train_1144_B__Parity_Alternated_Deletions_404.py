
N = input()

sequence = input().split()
oddSequence = []
evenSequence = []
total = 0
for number in sequence:
    placed = False
    number = int(number)
    if number%2 == 0:
        for index in range(len(evenSequence)):
            if not placed:
                even = evenSequence[index]
                if number < even:
                    evenSequence.insert(index, number)
                    placed = True
        if not placed:
                evenSequence.append(number)
    else:
        for index in range(len(oddSequence)):
            if not placed:
                odd = oddSequence[index]
                if number < odd:
                    oddSequence.insert(index, number)
                    placed = True
        if not placed:
                oddSequence.append(number)
    total = total + number
oddLength = len(oddSequence)
evenLength = len(evenSequence)
deleteType = 0
deletion = oddLength
if evenLength < deletion:
    deletion = evenLength
    deleteType = 1
if (oddLength-deletion-deleteType) <= 0:
    oddSequenceSum = 0
else:
    oddSequenceSum = sum(oddSequence[:(oddLength-deletion-deleteType)])
if (evenLength-deletion-(1-deleteType)) <= 0:
    evenSequenceSum = 0
else:
    evenSequenceSum =sum(evenSequence[:(evenLength-deletion-(1-deleteType))])
total = oddSequenceSum + evenSequenceSum
output = "%s" %total
print(output)
