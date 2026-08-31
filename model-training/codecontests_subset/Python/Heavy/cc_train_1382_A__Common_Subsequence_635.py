try:
    test=int(input())
    for i in range(test):
        len_arr1,len_arr2=map(int,input().strip().split())
        arr1=list(map(int,input().strip().split()))[:len_arr1]
        arr2=list(map(int,input().strip().split()))[:len_arr2]

        temp=[]
        arr1_set=list(set(arr1))
        arr2_set=list(set(arr2))

        for i in range(len(arr1_set)):
            if(arr1_set[i] in arr2_set):
                temp.append(arr1_set[i])
                
        if(len(temp)==0):
            print('NO')
        else:
            print('YES')
            print(1,temp[0])
        
except:
    pass
        
