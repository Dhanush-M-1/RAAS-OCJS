import math
def answer(n,a,m):
    s = 0
    max_sum = a[0]
    p_sums = [(a[0], 1)]
    for i in range(n):
        s+=a[i]
        if s>max_sum:
            max_sum = s
            p_sums.append((s, i+1))
    length = len(p_sums)

    
    x = list(map(int, input().split()))

    for i in range(m):
        xi = x[i]
        if s<=0 and max_sum<xi:
            print(-1, end = " ")
            continue
        
        
        if xi<=max_sum:
            rounds = 0
        else:
            rounds = math.ceil((xi-max_sum)/s)
        xi -= rounds*s
        l = 0
        r = length-1
        while(l<r):
            mid = (l+r)//2
            if p_sums[mid][0]<xi:
                l = mid+1
            else:
                r = mid
        print(rounds*n+p_sums[l][1]-1, end = " ")
    print("")

        

        
t = int(input())
for i in range(t):
    [n,m] = list(map(int , input().split()))
    a = list(map(int, input().split()))
    answer(n,a,m)

    
