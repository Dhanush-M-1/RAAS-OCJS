s = [int(i) for i in input().split('+')] #  создаёт массив
shetchikshetchikov = 0
while shetchikshetchikov < len(s) :
    shetchik = shetchikshetchikov
    maksimum = shetchik
    while shetchik < len(s) :
        if s[maksimum] > s[shetchik] :
            maksimum = shetchik
        shetchik = shetchik + 1 
    s[maksimum], s[shetchikshetchikov] = s[shetchikshetchikov] ,s[maksimum]
    shetchikshetchikov = shetchikshetchikov + 1
b = 0
a = ''
while b < len(s)  :  
    a = a + (str(s[b]))
    if len(s) - 1 > b :
        a = a +'+'
    b = b + 1
print(a)