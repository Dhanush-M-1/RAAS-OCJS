def poker_cow (n,seq) :
    total = 0
    ref = {"A" : 0 , "I" : 0 , "F" : 0 }
    for x in seq :
        ref[x] += 1
    
    if ref["I"] == 0 :
        return ref["A"]
    elif ref["I"] == 1 :
        return ref["I"]
    else :
        return 0 
        

n = int(input())
seq = input()

print (poker_cow(n,seq))