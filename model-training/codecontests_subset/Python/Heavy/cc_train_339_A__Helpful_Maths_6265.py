sumInput=input()
numbers=[]
for i in range(len(sumInput)):
    if(sumInput[i]!='+'):
        numbers.append(int(sumInput[i]))
#sorting
for i in range(1,len(numbers)):
    key=numbers[i]
    j=i-1
    while(key<numbers[j] and j>=0):
        numbers[j+1]=numbers[j]
        numbers[j]=key
        j-=1

numbersAndAddition=[]
j=0
for i in range(len(numbers)*2-1):
    if(i%2==0):
        numbersAndAddition.append(str(numbers[j]))
        j+=1
    else:
        numbersAndAddition.append(str("+"))
for i in range(len(numbersAndAddition)):
    print(numbersAndAddition[i], end='')



