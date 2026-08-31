def get_days(mon):
    if mon == '02':
        return '28'
    elif mon == '01' or mon == '03' or mon == '05' or mon == '07' or mon == '08' or mon == '10' or mon == '12':
        return '31'
    else:
        return '30'

def main():
    s = str(input())
    d = {}
    
    for i in range(len(s)-9):
        if s[i:i+10] not in d:
            d[s[i:i+10]] = 1
        else:
            d[s[i:i+10]] += 1

    d1 = {}
    digs = '0123456789'
    for (key,value) in d.items():
        if key[2] == key[5] and key[2] == '-':
            if key[6:9] == '201':
                if '3' <= key[9] <= '5' :
                    if (key[0] in digs) and (key[1] in digs) and (key[3] in digs) and (key[4] in digs):
                        d1[key] = value
    d2 = {}
    for (key,value) in d1.items():
        if 1 <= int(key[3:5]) <= 12:
            if 1 <= int(key[0:2]) <= int(get_days(key[3:5])):
                d2[key] = value;
    
    ans = 0
    ans_str = ''
    for (key,value) in d2.items():
        #print(key + " : " + str(value))
        if value > ans:
            ans = value
            ans_str = key
    print(ans_str)

    return

main()
