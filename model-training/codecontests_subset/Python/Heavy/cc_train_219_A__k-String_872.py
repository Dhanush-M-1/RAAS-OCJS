pattern = int(input())
s_string = list(input())
s_string.sort() #sort ascending
keyset = list(set(s_string)) #find out every unique char (no duplicate)
count = [x*0 for x in range(0,len(keyset))]
z = 0
res = ""
for chr in s_string: #count how many times unique chars appear in string
    if chr == keyset[z]:
        count[z]+=1
    else:
        z+=1
        if chr==keyset[z]:
            count[z]+=1
            
for x in range(0,len(count)): #determine wheter it is k-string-able
    if count[x]%pattern!=0:
        print("-1")
        exit(0)
    else:
        res += keyset[x]*int(count[x]/pattern)
print(res*pattern)        
  	 			  	   				 								