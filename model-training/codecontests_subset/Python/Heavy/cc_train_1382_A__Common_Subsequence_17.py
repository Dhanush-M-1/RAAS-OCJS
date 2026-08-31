t=int(input())
for j in range(t):
    n,m=map(int,input().split(" "))
    list1=list(map(int,input().split(" ")))
    list2=list(map(int,input().split(" ")))
    k=0
    if n>m:
        for j in list1:
            if j in list2:
                print('YES')
                print(1,j)
                k+=1
                break
    else:
        for j in list1:
            if j in list2:
                print('YES')
                print(1,j)
                k+=1
                break
    if not k:
        print('NO')
        
