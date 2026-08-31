string =  input()
string1 = ''
string2 = ''

length = len(string)
length1 = len(string1)

for i in range(0, length, 2):
    if string[i] == '1':
        string1 += '1'
    else:
        pass

for i in range(0, length, 2):
    if string[i] == '2':
        string1 += '2'
    else:
        pass

for i in range(0, length, 2):
    if string[i] == '3':
        string1 += '3'
    else:
        pass

for i in range(length):
    if i%2 == 0:
        string2 += string1[i//2]
    else:
        if i%2 == 1 and int(i/2)+1 < length:
            string2 += '+'
        else:
            break

print(string2)