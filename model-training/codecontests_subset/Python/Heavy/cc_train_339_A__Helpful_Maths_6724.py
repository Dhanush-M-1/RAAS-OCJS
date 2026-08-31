string = input()

count_1 = 0
count_2 = 0
count_3 = 0

for i in string:
	if i == "1":
		count_1 += 1
	elif i == "2":
		count_2 += 1
	elif i == "3":
		count_3 += 1

out = ""

for i in range(0,count_1):
	if count_1 == 1 and count_2 == 0 and count_3 == 0:
		out += "1"
	elif count_3 == 0 and count_2 == 0 and i == (count_1-1):
		out += "1"
	else:	
		out += "1+"

for i in range(0,count_2):
	if count_2 == 1 and count_1 == 0 and count_3 == 0:
		out += "2"
	elif count_3 == 0 and i == (count_2-1):
		out += "2"	
	else:	
		out += "2+"



for i in range(0,count_3):
	if count_3 == 1 and count_1 == 0 and count_2 == 0:
		out += "3"
	elif i == (count_3-1):
		out += "3"		
	else:	
		out += "3+"


print(out)
