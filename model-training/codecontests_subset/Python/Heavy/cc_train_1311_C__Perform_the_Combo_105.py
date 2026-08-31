def solve(n,m,S,P):
    #temp = np.zeros(26,dtype='int64')
    temp = [0]*26
    np_list = []
    for itr, s in enumerate(S):
        idx = ord(s)-97
        temp[idx] += 1
        temp_copy =temp[:]
        #temp_copy = np.copy(temp)
        if itr < n-1:
            #np_list.append(temp)
            np_list.append(temp_copy)
    ans = temp
    for p in P:
        #ans += np_list[p-1]
        for i,num in enumerate(np_list[p-1]):
            ans[i] += num
    #print(np_list)
    return ans

t = int(input())
for _ in range(t):
    n,m = map(int,input().split())
    S = input()
    P = list(map(int,input().split()))
    ans = solve(n,m,S,P)
    print(*ans)





