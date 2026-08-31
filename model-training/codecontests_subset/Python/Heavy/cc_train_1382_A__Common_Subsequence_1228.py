t = int(input())
for i in range(t):
    n,m = input().split()
    n = int(n)
    m = int(m)
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    dict1 = {}
    dict2 = {}
    c = 0
    for i in range(n):
        if a[i] in dict1:
            dict1[a[i]]+=1
        else:
            dict1[a[i]] = 1
    for i in range(m):
        if b[i] in dict2:
            dict2[b[i]]+=1
        else:
            dict2[b[i]] = 1
    for i in dict1:
        if i in dict2:
            print("YES")
            print("1",end = " ")
            print(i)
            c = 1
            break
    if(c == 0):
        print("NO")