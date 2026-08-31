def my_function(string):
    result = {}
    element = ""
    for i in range(len(string)):
        if(string[i] != " "):
            element += string[i]
            if(i == len(string) - 1):
                if element in result.keys():
                    result[element] += 1
                else:
                    result[element] = 1
        else:
            if element in result.keys():
                result[element] += 1
            else:
                result[element] = 1
            
            element = ""
    return result
n = int(input())
firstLine = my_function(input())
for repetition in range(2):
    consecutiveLine = my_function(input())
    for element in firstLine.keys():
        if element in consecutiveLine.keys():
            if(firstLine[element] > consecutiveLine[element]):
                firstLine[element] -= 1
                print (element)
                break
        else:
            if(firstLine[element] > 0):
                firstLine[element] -= 1
                print(element)
                break
			   		 	  	 	 							 		 	 	