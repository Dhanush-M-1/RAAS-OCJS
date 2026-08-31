q=int(input())
for i in range(q):
    j,w,d=map(int,input().split())
    if d<j or d>w:
        www=d
    else:
        
        www=((w//d)+1)*d
    print(www)
