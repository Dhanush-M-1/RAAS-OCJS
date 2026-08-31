t = int(input())
for k in range(t):
    l = 0
    n = int(input())
    a = [int(x) for x in input().split()]
    mina = a.index(min(a))  
    maxa = a.index(max(a)) 
    #print(a[mina],a[maxa])
    for i in range(n):
        if i != mina and a[mina] +a[i] <= a[maxa]:
            print(mina +1,i +1, maxa+1)
            l = 1
            break
    if l != 1:
        print(-1)
        