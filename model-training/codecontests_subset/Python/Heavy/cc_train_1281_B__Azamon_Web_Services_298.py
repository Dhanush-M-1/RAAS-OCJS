# f = open('file.txt', 'r+')
# inp = f.readline
inp = input

for _ in range( int( inp().strip() ) ):
    
    a , b = inp().strip().split(" ")
    
    if a < b :
        print(a)
        continue
        
    sa = list(sorted(a))
    aa = list(a)
    
#     print(sa , aa)
    
    if aa == sa:
        
        a = ''.join(aa)

        if a < b:
            print(a)
        else:
            print('---')
        continue
    
    k = 0
    for i , j in zip( aa , sa ):
        
        if i == j:
            k += 1
            continue
        else:
            break
    
    ch = -1
    trg = sa[k]
    for i in range(len(aa)-1 , -1 , -1):

        if aa[i] == trg:
            ch = i
            break
    
            
    aa[k] , aa[ch] = aa[ch] , aa[k]
    
    a = ''.join(aa)
    
    if a < b:
        print(a)
    else:
        print('---')