entry = input()

count = 0
one = 0
two = 0
three = 0
while count < len(entry):
	letter = entry[count]
	
	count = count + 1
	
	if letter == "1":
		one = one + 1
	if letter == "2":
		two = two + 1
	if letter == "3":
		three = three + 1
count = 0
result = ""	
while count < one:
	
	count = count + 1
	
	if result == "":
		result = result + "1"
	else:
		result = result + "+1"
	


count = 0

while count < two:
	
	count = count + 1
	
	if result == "":
		result = result + "2"
	else:
		result = result + "+2"
	

count = 0

while count < three:
	
	count = count + 1
	
	if result == "":
		result = result + "3"
	else:
		result = result + "+3"

print (result)	