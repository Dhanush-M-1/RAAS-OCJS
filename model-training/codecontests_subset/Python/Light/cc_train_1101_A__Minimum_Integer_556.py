n = int(input())
for _ in range(n):
               
    l,r,d = map(int,input().split())
    if d<l:
        print(d)
    else:
        a = r//d
        print((a+1)*d)
        
               
