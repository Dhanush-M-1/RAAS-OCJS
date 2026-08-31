for _ in range(int(input())):
    n = int(input())
    x=0
    y=0
    ch=0
    l=[]
    for i in range(n):
        p,c = map(int,input().split())
        l.append([p,c])
    for i in l:
        p=i[0]
        c=i[1]
        if p-x < c-y:
            print("NO")
            ch=1
            break
        if p>=x and c>=y:
            if c>p:
                print("NO")
                ch=1
                break
        
        else:
            print("NO")
            ch=1
            break
        x=p
        y=c
    if ch ==0:
        print("YES")