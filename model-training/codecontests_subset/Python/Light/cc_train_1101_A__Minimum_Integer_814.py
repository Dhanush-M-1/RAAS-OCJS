q=int(input())
for _ in range(q):
    l,r,d=map(int,input().split())
    left=0
    right=0
    if d==1:
        if l==1:
            print(r+1)
        else:
            print(1)
    else:
        
        if l%d==0:
            left+=1
        if r%d==0:
            right+=1
        if l//d -left>0:
            print(d)
        else:
            print(r-r%d+d)
