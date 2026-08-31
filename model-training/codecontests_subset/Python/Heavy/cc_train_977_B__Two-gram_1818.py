def calculate(substring, originalString):
    ct = 0
    maximum = 0

    i = 0
    while (i < len(originalString) - 1):
        if (len(substring) > 1):        
            if (originalString[i] == substring[0] and originalString[i + 1] == substring[1]):
                ct +=1
        i += 1

    return ct

n = int(input())
s = input()
maximum = 0
result = ""

for i in range(0, len(s)):
    partial = s[i: (i + 2)]
    temp = calculate(partial, s)

    if (temp > maximum):
        maximum = temp
        result = partial

print(result)
	      						   	 		 		 		  	 	