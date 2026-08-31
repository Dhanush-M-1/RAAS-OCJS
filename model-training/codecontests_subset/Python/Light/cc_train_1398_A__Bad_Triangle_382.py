t = int(input())
for _ in range(t):
    n = int(input())
    lol=[int(n) for n in input().split()]
    z=lol.copy()
    z.sort()
    if(z[0] + z[1] <=z[-1]):
        #if(z[0]==z[1]):
            
        print(1,2,n)
        '''print(lol.index(z[0]),end=' ')
        lol.remove(z[0])
        print(lol.index(z[1]),end=' ')
        print(lol.index(z[-1]),end=' ')'''
    else:
        print(-1)
        
    