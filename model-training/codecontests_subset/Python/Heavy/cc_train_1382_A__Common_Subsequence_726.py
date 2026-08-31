for _ in range(int(input())):
    n1,n2 = map(int,input().split())
    lst1 = list(map(int,input().split()))
    lst2 = list(map(int,input().split()))
    found=False
    if(n1>=n2):
        for i in range(n1):
            if(lst1[i] in lst2):
                print('YES')
                found=True
                print(1,lst1[i])
                break
    else:
        for i in range(n2):
            if(lst2[i] in lst1):
                print('YES')
                found=True
                print(1,lst2[i])
                break
    if(found==False):
        print('NO')
