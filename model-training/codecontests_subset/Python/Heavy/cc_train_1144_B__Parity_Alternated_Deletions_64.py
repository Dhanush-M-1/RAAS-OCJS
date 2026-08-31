times = int(input())
even = 0
final = 0
evenArray = [10000001]*times
oddArray = [10000001]*times
even = 0
odd = 0
numbers = input().split()
for counter in range(times):
    numbers[counter] = int(numbers[counter])
for count in range(times):
    if numbers[count]%2==0:
        evenArray[even] = numbers[count]
        even +=1
    if numbers[count]%2==1:
        oddArray[odd] = numbers[count]
        odd +=1
'''print(oddArray)
print(evenArray)'''
if even+1<odd:
    if times ==2:
        final = oddArray[0]
    else:
        oddArray.sort()
        for count in range(odd-even-1):
            final = final+oddArray[count]
if odd+1<even:
    if times ==2:
        final = evenArray[0]
    else:
        evenArray.sort()
        for count in range(even-odd-1):
            final = final+evenArray[count]
if even==odd or even==odd+1 or odd==even+1:
    final = 0
print(final)