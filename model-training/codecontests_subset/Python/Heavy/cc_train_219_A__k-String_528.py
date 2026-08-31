k = int(input())
s = input()

arr_chars = {}
for char in s:
    if (arr_chars.get(char) != None):
        arr_chars[char] += 1
    else:
        arr_chars.update({char: 1})

result = 0
for char in arr_chars:
    if not(arr_chars[char] % k == 0):
        result = -1

if result != -1:
    result = ""
    ct_char_0 = 0

    tamanho = len(arr_chars)
    arr_chars_copy = {}
    for char in arr_chars:
        qtd = arr_chars[char] // k
        arr_chars_copy.update({char: qtd})
    
    while (ct_char_0 < tamanho):
        arr_char_to_remove = []

        for char in arr_chars:
            qtd = arr_chars_copy[char]
            while (qtd > 0):
                result += char
                arr_chars[char] -= 1
                qtd -= 1
            
            if (arr_chars[char] <= 0):
                ct_char_0 += 1
                arr_char_to_remove.append(char)
                
        for char in arr_char_to_remove:
            del arr_chars[char]

    print(result)
else:
    print(result)
	 			     			 	  	 		 	  		  		