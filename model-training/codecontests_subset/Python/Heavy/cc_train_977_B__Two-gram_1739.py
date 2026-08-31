def hate_for_one_check(str_len, dgramm):
    if str_len == 2:
        print (dgramm)
        return
    
    cardmaster = []
    for sub in range(len(dgramm)):
        cardmaster.append(dgramm[sub:sub+2:])
        sub +=2
    
    if str_len % 2 == 0:
        del cardmaster[-1]
    #print(cardmaster)
    
    
    result = dict()
    for sub in cardmaster:
        if sub not in result:
            result[sub] = 1
        else:
            result[sub] +=1
 
    
    max_value = max(result.values())
    max_keys = [k for k, v in result.items() if v == max_value]
    print((max_keys)[0])


str_len = int(input())
dgramm = input()
hate_for_one_check(str_len, dgramm)
