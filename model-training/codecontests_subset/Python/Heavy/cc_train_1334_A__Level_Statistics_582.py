import sys
input = sys.stdin.readline

############ ---- USER DEFINED INPUT FUNCTIONS ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(s[:len(s) - 1])
def invr():
    return(map(int,input().split()))
################################################################
############ ---- THE ACTUAL CODE STARTS BELOW ---- ############

t = inp()

for _ in range(t):
    n = inp()
    a,b = 0,0
    has = True
    for i in range(n):
        play,clear = invr()
        if play > a:
            clear_lim = play - a
            if clear >= b:
                if clear - b > clear_lim:
                    has = False
                    
            else:
                has = False
                
        elif play < a:
            has = False
            
        else:
            if clear < b or clear > b:
                has = False
                
        a,b = play,clear
    if has:
        print('YES')
    else:
        print('NO')
    
