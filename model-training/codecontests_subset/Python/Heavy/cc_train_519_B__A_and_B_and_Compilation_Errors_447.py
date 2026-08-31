n = int(input())
first = {}
second = {}
third = {}

line = input().split()
for number in line:
    if number in first:
        first[number] += 1
    else:
        first[number] = 0

line = input().split()
for number in line:
    if number in second:
        second[number] += 1
    else:
        second[number] = 0

line = input().split()
for number in line:
    if number in third:
        third[number] += 1
    else:
        third[number] = 0

for number in first:
    if (not number in second) or first[number] != second[number]:
        print(number)

for number in second:
    if (not number in third) or second[number] != third[number]:
        print(number)
		    	 	 		  	  	  	  	 			 	