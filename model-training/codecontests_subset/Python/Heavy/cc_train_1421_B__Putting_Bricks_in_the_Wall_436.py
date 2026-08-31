t = int(input())
 
while t:
    t -= 1
    n = int (input())
    a= []
    for i in range (n):
        line = list (input())
        #line = [int(x) for x in line if x not in {'S', 'F'} else x]
        a.append (line)
    
    #a,b,c,d = cells which over start and finish points    
    x, y, z, w = a[0][1], a[1][0], a[n-2][n-1], a[n-1][n-2]
    
    if x==y and z==w:
        if x != z:
            print (0)
            continue
        elif x == z:
            print (2)
            print ('1 2')
            print ('2 1')
            continue
    elif x == y and z != w:
        if x == z:
            print (1)
            print (str (n-1)+' '+str (n))
            continue
        else:
            print (1)
            print (str(n)+' '+str(n-1))
            continue
    elif x!=y and z==w:
        if x == z:
            print (1)
            print ('1 2')
            continue
        else:
            print (1)
            print ('2 1')
            continue
    elif x!=y and z!=w:
        if x == z:
            print (2)
            print ('1 2')
            print (str(n)+' '+str(n-1))
            continue
        else:
            print (2)
            print ('1 2')
            print (str(n-1)+' '+str(n))
            continue
        