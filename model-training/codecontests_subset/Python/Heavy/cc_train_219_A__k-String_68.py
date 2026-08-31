k = int(input())
string = input()
letters = []
indexes = []

for letter in string:
    if letter in letters:
        indexes[letters.index(letter)] += 1
    else:
        letters.append(letter)
        indexes.append(1)

for i in indexes:
    if i%k != 0:
        print('-1')
        quit()

kstring = ''
for i in range(0,len(indexes)):
    for n in range(0,int(indexes[i]/k)):
        kstring += letters[i]
        
final = ''
for venceslau in range(0,k):
    final = final + kstring

print (final)
  		   	 		 	 		 		 			 	  	 		