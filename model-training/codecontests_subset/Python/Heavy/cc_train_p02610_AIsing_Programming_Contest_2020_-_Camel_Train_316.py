import heapq
t = int(input())
for i in range(t):
    n = int(input())
    ans = 0
    cl,cr = 0,0
    lisl = []
    lisr = []
    rs = 0
    ls = 0
    for i in range(n):
        k,l,r = map(int,input().split())
        a = r-l
        s = (l>r)
        if a<0:
            lisl.append([k,l,r,-a,s])
            rs += r
        else:
            lisr.append([k,l,r,a,s])
            ls += l
    lisl.sort(key=lambda x: x[0])
    lisr.sort(key=lambda x: x[0],reverse=1)
    h = []
    cntl = 0
    cntr = 0
    for i in lisl:
        heapq.heappush(h,i[3])
        cntl += 1
        if cntl > i[0]:
            heapq.heappop(h)
            cntl -= 1
    hr = []
    for i in lisr:
        heapq.heappush(hr,i[3])
        cntr += 1
        if cntr > n-i[0]:
            heapq.heappop(hr)
            cntr -= 1
    print(rs+sum(h)+ls+sum(hr))