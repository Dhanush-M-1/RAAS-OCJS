n = int(input())
s = input()


grams = {}
mfg = ["" , 0]
for index in range(len(s)-1):
    if s[index] + s[index+1] in grams:
        grams[s[index] + s[index+1]] += 1
        if grams[s[index] + s[index+1]] > mfg[1]:
            mfg[0] = s[index] + s[index+1]
            mfg[1] =  grams[s[index] + s[index+1]]
    else:
        grams.update({ s[index] + s[index + 1] : 1 })
        if grams[s[index] + s[index+1]] > mfg[1]:
            mfg[0] = s[index] + s[index+1]
            mfg[1] =  grams[s[index] + s[index+1]]
print(mfg[0])
			  	   			   		  	 	 		  	 		