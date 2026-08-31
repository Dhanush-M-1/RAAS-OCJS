T = int(input())
for t in range(T):
    l, r, d = [int(i) for i in input().split()]
    i=0
    while d*(r//d + i) <= r:
        i+=1
    ans = d*(r//d+i)    
    ans2 = d
    if ans2<l:
        print(ans2)
    else:
        print(ans)

