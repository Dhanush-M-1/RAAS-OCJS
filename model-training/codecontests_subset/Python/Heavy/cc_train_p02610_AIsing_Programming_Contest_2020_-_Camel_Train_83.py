import heapq

def func():
    N = int(input())
    L_list = []
    L_ind = [[]for i in range(N)]
    R_list = []
    R_ind = [[]for i in range(N+1)]
    ans = 0
    for i in range(N):
        k,l,r = map(int,input().split())
        if l > r:
            L_list.append(l-r)
            L_ind[k-1].append(len(L_list)-1)
            ans += r
        elif r > l:
            R_list.append(r-l)
            R_ind[N-k].append(len(R_list)-1)
            ans += l
        else:
            ans += l

    L_heap = []
    for i in range(N):
        for j in L_ind[i]:
            heapq.heappush(L_heap,L_list[j])
        while len(L_heap) > i+1:
            heapq.heappop(L_heap)
    R_heap = []
    for i in range(N):
        for j in R_ind[i+1]:
            heapq.heappush(R_heap,R_list[j])
        while len(R_heap) > i+1:
            heapq.heappop(R_heap)
    return(ans+sum(L_heap)+sum(R_heap))
    

T= int(input())
for i in range(T):
    print(func())