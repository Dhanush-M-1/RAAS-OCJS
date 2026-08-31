for _ in range(int(input())):
    n = int(input())
    l = [int(s) for s in input().split()]
    if len(set(l))<3:
        print(0,0,0)
        continue
    i = n//2-1
    # print(i)
    if l[n//2-1]==l[n//2]:
        while i>=0 and l[i]==l[n//2]:
            i-=1
        if i<0:
            print(0,0,0)
            continue
    # print(i)
    # print(l)
    l = l[:i+1]
    # print(l)
    if len(set(l))<3:
        print(0,0,0)
        continue
    i = 1
    while l[i]==l[0]:
        i+=1
    g = i
    s = 0
    flag = 0
    while s<=g:
        j =i
        if j==len(l):
            flag = 1
            break
        while i<len(l) and l[i]==l[j]:
            i+=1
        s = i-g
    if flag:
        print(0,0,0)
        continue
    b = len(l)-g-s
    if g>=b or g>=s:
        print(0,0,0)
        continue
    print(g,s,b)