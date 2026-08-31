from collections import Counter
def Sol(st,k):
    
    
    data = Counter(st)
    d = data.most_common()
    
    for i in d:
        if i[1]%k != 0:
            print(-1)
            return
    c = list(data.values())
    c.sort(reverse=True)

    for i in range(len(c)):
        c[i] = int(c[i]/k)
    ans = ''
    it = 0
    l = len(c)
    count = 0
    while True:
        if d[0][1] != 0:
            ans += d[0][0]*c[it]
            d = d[1:] + [(d[0][0],d[0][1]-c[it])]
            it += 1
            
            if it%l == 0:
                it = 0
        else:
            break
    print(ans)
    return

    

#for t in range(int(input())):
#n,k = map(int,input().split())
#n = int(input())
#arr = list(map(int,input().split()))
k = int(input())
n = input()
Sol(n,k)

