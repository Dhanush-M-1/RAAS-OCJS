t = int(input())
for z in range(t):
    arr = list(map(int,input().split()))
    n,m= arr[0],arr[1]
    c = []
    i,j=0,0
    a = list(map(int, input().split()))
    b =list (map(int, input().split()))
    
    while(i < n):
        array = []
        no = a[i]
        while ( j < m  and b[j] != no) :
            j+=1
        if (j!=m):
            array.append(no)
            break 
        else :
            i +=1
            j = 0
    if (len(array)):
        print ("YES")
        print (len(array),end = ' ' )
        for i in array:
            print(i,end = ' ')
        print()
    else:
        print("NO")
    

        
