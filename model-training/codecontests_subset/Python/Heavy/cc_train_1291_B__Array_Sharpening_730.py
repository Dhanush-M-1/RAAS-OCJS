
tests = int(input())

for te in range(tests):
    n = int(input())
    arr = list(map(int,input().split()))
    l = -1
    for i in range(n):
        if(arr[i] >= i):
            l = i
        else:
            break

    r = n-1
    flag = 0
    for i in range(n-1,-1,-1):
        if(arr[i] >= n-i-1):
            r = i
            if(i == l):
                flag = 1
                break

        else:
            break
        
    if(flag == 1 or n==1):
        #print('l'+str(l))
        #print('r'+str(r))
        print('Yes')
    else:
        print('No')


'''tests = int(input())

for te in range(tests):
    n = int(input())
    arr = list(map(int ,input().split()))
    for i in range(n):
        if(arr[i] >= i):
            arr[i] = i
    for i in range(n-1,-1,-1):
        if(arr[i] >= n-1-i):
            arr[i] = n-1-i
    l = 0
    for i in range(1,n):
        if(arr[i] > arr[i-1]):
            l = i

    r = n-1
    for i in range(n-2,l,-1):
        if(arr[i] > arr[i+1]):
            r = i

    if( l == r):
        print('Yes')
    elif(l == r-1 and arr[l] > arr[r]):
        print('Yes')
    else:
        print('No')
    '''
    
