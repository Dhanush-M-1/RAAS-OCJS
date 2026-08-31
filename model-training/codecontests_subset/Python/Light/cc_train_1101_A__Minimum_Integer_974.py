t = int(input())
for _ in range(t):
    p,q,r = list(map(int,input().split()))
    if r<p:
        print(r)
    else:
        print((q//r+1)*r)
