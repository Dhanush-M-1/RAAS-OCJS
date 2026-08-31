
n = int(input())

for q in range(n):
    l,r,d = map(int,input().strip().split())

    if d*1 < l:
        print(d)
        #print("t")
    else:
        r+=1
        if r%d==0:
            print(r)
            continue
        r-=r%d
        #print(r)
        r+=d
        print(r)
