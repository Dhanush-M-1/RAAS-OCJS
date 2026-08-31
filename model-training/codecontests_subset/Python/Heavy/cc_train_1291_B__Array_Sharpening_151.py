
t = int(input())

for loop in range(t):

    n = int(input())

    a = list(map(int,input().split()))

    lis = [None] * n
    flag = False

    for i in range(n):

        if a[i] >= i:
            lis[i] = i
        else:
            break

    for i in range(n):
        
        j = n-1-i
        if lis[j] == None and a[j] >= i:
            lis[j] = i
        else:
            if lis[j] != None and (j == n-1 or lis[j] != lis[j+1]):
                flag = True
            break

    #print (lis)

    if flag:
        print ("Yes")
        continue

    lis = [None] * n
    for i in range(n):
        
        j = n-1-i
        if a[j] >= i:
            lis[j] = i
        else:
            break

    for i in range(n):

        if lis[i] == None and a[i] >= i:
            lis[i] = i
        else:
            if lis[i] != None and (i == 0 or lis[i] != lis[i-1]):
                flag = True
            break

    #print (lis)

    if flag:
        print ("Yes")
    else:
        print ("No")
 
    
        
