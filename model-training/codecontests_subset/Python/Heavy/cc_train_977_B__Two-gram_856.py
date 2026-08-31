input()                                          
                                                 
s = input()                                      
freq = [0] * 26**2                               
                                                 
def hash(s):                                     
    return (ord(s[0]) - 65) * 26 + ord(s[1]) - 65
                                                 
def unhash(n):                                   
    l, r = divmod(n, 26)                         
    return chr(65+l) + chr(65+r)                 
                                                 
for i in range(len(s)-1):                        
    freq[hash(s[i:i+2])] += 1                    
                                                 
best = 0                                         
bi = 0                                           
for i, f in enumerate(freq):                     
    if f > best:                                 
        best = f                                 
        bi = i                                   
                                                 
print(unhash(bi))                                