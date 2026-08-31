n=int(input())
for i in range(n):
    l,r,d=map(int,input().split())
    if d*1<l:
        print(d)
        continue 
    print(r//d*d+d)