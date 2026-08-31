
trash = input()
text = input()

asw = ""
max_count = 0
for i in range(0, len(text) - 1):
    first_letter = text[i]
    second_letter = text[i + 1]

    count = 0

    for ii in range(0, len(text) - 1):
        ifirst_letter = text[ii]
        isecond_letter = text[ii + 1]
        if ifirst_letter == first_letter and second_letter == isecond_letter:
            count = count + 1

    if (count > max_count):
        max_count = count
        asw = first_letter + second_letter



print(asw)

	  						   			 	  		 	  	  			