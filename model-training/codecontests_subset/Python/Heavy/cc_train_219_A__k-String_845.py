def main():
    k = int(input())
    string = input()
    alpha = "abcdefghijklmnopqrstuvwxyz"
    alphabet = [0,0,0,0,0,
                0,0,0,0,0,
                0,0,0,0,0,
                0,0,0,0,0,
                0,0,0,0,0,0]
    for word in string:
        alphabet[alpha.index(word)] += 1
    check = True
    for a in alphabet:
        if(a != 0):
            if(a%k != 0):
                check = False
    if(check):
        letters = []
        times = []
        for j in range(len(alphabet)):
            a = alphabet[j]
            if(a != 0):
                letters.append(alpha[j])
                times.append(int(alphabet[j]/k))
        stringFinal = ""
        i = 0
        while i < k:
            for l in range(len(letters)):
                for t in range(times[l]):
                    stringFinal += letters[l]
            i+= 1
        print(stringFinal)
    else:
        print("-1")

main()  


					  		 				  	 					  		   	