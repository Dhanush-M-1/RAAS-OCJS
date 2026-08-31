stroka = input()

vivod = '' 
dlina = (len(stroka) - 1 ) / 2 + 1
i = 0 
kolvo_1 = 0
kolvo_2 = 0
kolvo_3 = 0
j = 0

while j < dlina:
    if dlina < 2:
        vivod = stroka
        break
    
    if stroka[0 + i] == '1':
        kolvo_1 += 1
        
    elif stroka[0 + i] == '2':
        kolvo_2 += 1
        
    elif stroka[0 + i] == '3':
        kolvo_3 += 1     
    i += 2
    j += 1

if kolvo_1 > 0:
    vivod = ('1' + '+') * (kolvo_1 - 1) + '1'

if kolvo_2 > 0:
    if kolvo_1 > 0:
        vivod += '+'
    vivod += ('2' + '+') * (kolvo_2 - 1) + '2'
    

if kolvo_3 > 0:
     if kolvo_1 > 0 or kolvo_2 > 0:
        vivod += '+' 
     vivod += ('3' + '+') * (kolvo_3 - 1) + '3'
   

print(vivod)