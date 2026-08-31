n = int(input())
nos = input()
numbers = []
for s in nos:
    numbers.append(int(s))
#print(numbers)

if n < 11: 
    print('0')
else:
    poss = int(n/11)
    #print("Possible: ", poss)
    no_of_eight = 0
    for i in range(n):
        if numbers[i] == 8:
            no_of_eight += 1
    #print("No. of 8: ", no_of_eight)
    print(min(no_of_eight, poss))