for _ in range(int(input())):
    size1,size2 = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int, input().split()))
    block = True
    if(a<b):
        for i in a:
            if i in b:
                print("YES")
                print(1,i)
                block = False
                break
    else:
        for i in b:
            if i in a:
                print("YES")
                print(1,i)
                block = False
                break
    if(block):
        print("NO")

