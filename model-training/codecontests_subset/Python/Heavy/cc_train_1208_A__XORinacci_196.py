def xorinacci(a, b, n):
    if(n == 0):
        return a
    if(n == 1):
        return b

    binA = bin(a)
    binB = bin(b)

    #print(a, "= binA =", binA)
    #print(b, "= binB =", binB)

    # They need to be of the same lenght
    difLen = len(binA) - len(binB)
    if(difLen < 0):
        binA = "0b" + ("0" * (-difLen)) + binA[2:]
    else:
        binB = "0b" + ("0" *   difLen ) + binB[2:]

    #print("binA =", binA)
    #print("binB =", binB)

    binAux = "0b"
    for i in range(2, len(binA)):
        if(binA[i] == binB[i] == "0"):
            binAux += "0"
            continue

        if(binA[i] == "0" and binB[i] == "1"):
            remainder = 0
        elif(binA[i] == "1" and binB[i] == "1"):
            remainder = 1
        elif(binA[i] == "1" and binB[i] == "0"):
            remainder = 2

        final = (remainder + n) % 3
        if(final == 0):
            xor = "0"
        elif(final == 1):
            xor = "1"
        else:
            xor = "1"

        binAux += xor

    #print("binAux =", binAux)
    #print(" ---------------------- ")
    #print()

    return int(binAux[2:], 2)

testCases = int(input())
for t in range(testCases):
    a, b, n = tuple(map(int, input().split(" ")))
    f = xorinacci(a, b, n)
    print(f)

	 		 			 				    				 	   		  	