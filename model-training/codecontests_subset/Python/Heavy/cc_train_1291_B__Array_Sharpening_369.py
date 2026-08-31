for i in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    p1,p2 = set(),set()
    arr2 = arr[::]
    for i in range(0,len(arr)):
        if arr[i]>=i:
            arr[i] = i
            p1.add(i)
        else:
            break
    # p1 = i-1
    
    for j in range(len(arr2)-1,-1,-1):
        if arr2[j]>=len(arr2)-j-1:
            arr2[j] = len(arr2)-j-1
            # p2+=1
            p2.add(j)
        else:
            break

    d = p1 & p2
    if len(d)>0 or len(p2)==n or len(p1)==n:
        print('Yes')
    else:
        print('No')
    # if p2 == n:
    #     print('Yes')
    # else:
    #     print('No')

    