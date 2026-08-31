t = int(input())
while t>0:
    t = t-1
    n,m = map(int,input().split())
    s = [i for i in input()]
    p = list(map(int,input().split()))
    
    b = [0 for i in range(n)]
    for i in p:
        b[i-1] += 1
    temp = [0 for i in range(n)]
    val = m+1
    i = 0
    while i<n:
        if b[i] == 0:
            temp[i] = (val)
        elif b[i] > 0:
            temp[i] = val
            val -= b[i]
        i += 1
    # print(temp)
    a = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    for i in range(len(a)):
        letter = a[i]
        c = 0
        count = 0
        for j in range(n):
            if s[j] == letter:
                count += temp[j]
        print(count,end=" ")
    print()