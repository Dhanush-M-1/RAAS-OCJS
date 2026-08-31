a = int(input())
for i in range(a):
    q,w,e = map(int, input().split())
    if(e<q):
        print(e)
    else:
        print((w//e+1)*e)
