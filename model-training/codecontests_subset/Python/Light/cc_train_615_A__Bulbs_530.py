#MAde BY the Control , Enjoy

flag=True
line=input().split()
buttons=int(line[0])
bulps=int(line[1])
#print(buttons,bulps)


array_of_bulbs=[]
for i in range(buttons):
	line_input=input().split()
	for i in range(1,len(line_input)):
		array_of_bulbs.append(int(line_input[i]))

#print(array_of_bulbs)
for i in range(1,bulps+1):
	if i not in array_of_bulbs:
		#print(i)
		flag=False

if flag:
	print('YES')
else:
	print('NO')
