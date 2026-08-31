n = int(input())
for j in range(n):
    m = int(input())
    L = [int(e) for e in input().strip().split()]
    L = L[: (len(L)//2) + 1 ]
    if len(L) == 1: pass
    elif L[-1] == L[-2]:
        i = -2
        while( i >= len(L)*-1 and L[i] == L[-1]):
            i -= 1
        L = L[:i+1]        
    else:
        L = L[:-1]
    if len(L) == 0: L = [9999]
    
    L2 = []
    tmp = L[0]; count = 0
    for i in range(len(L)):
        if L[i] == tmp:
            count += 1
        else:
            L2.append(count)
            count = 1
            tmp = L[i]
        if i == len(L)-1: L2.append(count)
           
    if len(L2) > 3:
        ans = [0,0,0]
        ans[0] = L2[0]
        i = 2
        silver = L2[1]
        while silver <= ans[0] and i <= len(L2)-1:
            silver += L2[i]
            i += 1       
        ans[1] = silver
        if i <= len(L2)-1:
            ans[2] = sum(L2[i:])
    elif len(L2) == 1: ans = L2 + [0,0]
    elif len(L2) == 2: ans = L2 + [0]
    else:
        ans = L2
 
    #recheck
    if ans[1] == 0 or ans[2] == 0: ans = [0]*3
    if ans[1] <= ans[0] or ans[2] <= ans[0]: ans = [0]*3
    print(" ".join([str(e) for e in ans]))
