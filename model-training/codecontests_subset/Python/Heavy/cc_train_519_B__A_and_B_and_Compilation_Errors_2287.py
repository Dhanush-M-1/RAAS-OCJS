n = int(input())
second_line = input().split()
second_line.sort()
third_line = input().split()
third_line.sort()
fourth_line = input().split()
fourth_line.sort()

count = 0
def error1(second_line,third_line):
	global count
	for i in range(len(second_line)):
		try:
			if second_line[i] != third_line[i] and second_line[i+1] == third_line[i]:
				if count != 0:
					count = i
				return second_line[i]
				break
			elif second_line[i] != third_line[i] and second_line[i+1] != third_line[i]:
				count = i
		except:
			return second_line[i]

def error2(third_line,fourth_line):
	global count
	for i in range(count,len(third_line)):
		try:
			if third_line[i] != fourth_line[i]:
				return third_line[i]
				break
		except:
			return third_line[i]


print(error1(second_line,third_line))
print(error2(third_line,fourth_line))
	 		 		  				 	 		    	  	