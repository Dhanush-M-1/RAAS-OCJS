q=int(input())
for i in range(q):
    i=0
    (a,b,c)=map(int,input().split())
    if a<=c<=b:
        i=int(b/c)
        print(c*(i+1))
    else:
        print(c)