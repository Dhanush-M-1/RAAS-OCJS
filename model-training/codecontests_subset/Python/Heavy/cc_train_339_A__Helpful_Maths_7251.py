def corrected_string(s):
    ones,twos,threes=0,0,0
    n_s=[]
    for i in range(0,len(s),2):
        if ord(s[i])==49:
            ones +=1
        elif ord(s[i])==50:
            twos +=1
        elif ord(s[i])==51:
            threes +=1
    while ones !=0:
        n_s.append('1')
        n_s.append('+')
        ones -=1
    while twos !=0:
        n_s.append('2')
        n_s.append('+')
        twos -=1
    while threes !=0:
        n_s.append('3')
        n_s.append('+')
        threes -=1
        
    return ''.join(n_s[:len(s)])

s=input()
print(corrected_string(s))