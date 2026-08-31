
#q = int(input())
#x, y = map(int,input().split(' '))
#print (' '.join(list(map(str, s))))

q = int(input())

for i in range(q):
    n = int(input())
    p = list(map(int,input().split(' ')))
    
    if n < 10:
        print('0 0 0')
        continue
    
    mx = n//2
    
    g = 1
    while g < mx and p[g] == p[0]:
        g = g + 1
    
    if g * 3 + 2 > mx:
        print('0 0 0')
        continue
    
    s = 2 * g + 1
    while s < mx and p[s] == p[2*g]:
        s = s + 1
        
    b = mx - 1
    if p[b] == p[mx]:
        tmp = p[b]
        while b > 0 and p[b] == tmp:
            b = b - 1
    
    if b-s+1 <= g:
        print('0 0 0')
        continue
                
    out = str(g) + ' ' + str(s-g) + ' ' + str(b-s+1)
    print(out)
    