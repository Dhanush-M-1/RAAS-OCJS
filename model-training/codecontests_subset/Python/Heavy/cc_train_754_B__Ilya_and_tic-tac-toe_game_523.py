def horizontal (arr,o,i) :
    r = [arr[o][i],arr[o][i+1],arr[o][i+2]]
    l = [arr[o][i],arr[o][i-1],arr[o][i-2]]
    m = [arr[o][i-1],arr[o][i],arr[o][i+1]]
    
    all = [r,l,m]
    
    for i,j,k in all :
        if i == None or j == None or k == None or i == "o" or j == "o"\
        or k == "o":
            continue
        
        if i == j == "." or i == k == "." or j == k == "." :
            continue
        
        else :
            return 1
        
    return 0

def vertical (arr,o,i) :
    r = [arr[o][i],arr[o+1][i],arr[o+2][i]]
    l = [arr[o][i],arr[o-1][i],arr[o-2][i]]
    m = [arr[o-1][i],arr[o][i],arr[o+1][i]]
    
    all = [r,l,m]
    
    for i,j,k in all :
        if i == None or j == None or k == None or i == "o" or j == "o"\
        or k == "o":
            continue
        
        if i == j == "." or i == k == "." or j == k == "." :
            continue
        
        else :
            return 1
        
    return 0

def leftDiagonal (arr,o,i) :
    r = [arr[o][i],arr[o+1][i+1],arr[o+2][i+2]]
    l = [arr[o][i],arr[o-1][i-1],arr[o-2][i-2]]
    m = [arr[o-1][i-1],arr[o][i],arr[o+1][i+1]]
    
    all = [r,l,m]
    
    for i,j,k in all :
        if i == None or j == None or k == None or i == "o" or j == "o"\
        or k == "o":
            continue
        
        if i == j == "." or i == k == "." or j == k == "." :
            continue
        
        else :
            return 1
        
    return 0
    
def rightDiagonal (arr,o,i) :
    r = [arr[o][i],arr[o+1][i-1],arr[o+2][i-2]]
    l = [arr[o][i],arr[o-1][i+1],arr[o-2][i+2]]
    m = [arr[o-1][i+1],arr[o][i],arr[o+1][i-1]]
    
    
    all = [r,l,m]
    
    for i,j,k in all :
        
        if i == None or j == None or k == None or i == "o" or j == "o"\
        or k == "o":
            continue
        
        if i == j == "." or i == k == "." or j == k == "." :
            continue
        
        else :
            
            return 1
        
    return 0
    
    


def solve (seq) :
    outer = 2
    while outer < 6 :
        inner = 2
        while inner < 6 :
            if seq[outer][inner] == "x" :
                if horizontal(seq,outer,inner) == 1 :
                    return "YES"
                elif vertical(seq,outer,inner) == 1:
                    return "YES"
                elif leftDiagonal(seq,outer,inner) == 1 :
                    return "YES"
                elif rightDiagonal(seq,outer,inner) == 1 :
                    return "YES"
            inner += 1
        outer += 1
    
    return "NO"
            


seq = [[None]*8]*2

for x in range(4) :
    n = [None,None]
    n.extend(list(input()))
    n.append(None)
    n.append(None)
    seq.append(n)
    
for y in range(2) :
    seq.append([None]*8)

print (solve(seq))
    



    
   