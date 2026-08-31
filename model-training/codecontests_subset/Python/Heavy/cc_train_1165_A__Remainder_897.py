inputs = list(map(int, input().split()))
n = inputs[0]
x = inputs[1]
y = inputs[2]
num_string = (input())

# print(checklen)

# if there's zero in (y-1)~last and 1 in yth digit from the last  
counter = 0
checker = 0
for c in reversed(num_string):
	# print("---")
	# print(c)
	if checker==y:
		if c=='0':
			counter+=1
		checker+=1

		# print("--{}---".format(counter))
		continue
	if checker>=x:
		# print("-------{}---".format(counter))
		break

	if c=='1':
		counter+=1

	checker+=1
	# print("{}---".format(counter))


print(counter)



