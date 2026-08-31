n = int(input())
abc = 'abcdefghijklmnopqrstuvwxyz'
def sub(l, i):
    if len(l) >= n:
        print(l)
        return
    for k in range(i):
        sub(l + abc[k], i)
    sub(l + abc[i], i + 1)

sub('', 0)
    
    


