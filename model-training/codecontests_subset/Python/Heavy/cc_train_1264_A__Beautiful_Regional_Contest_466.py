import sys
input = sys.stdin.readline

t = int(input())
for i in range(t):
    n = int(input())
    data = [int(i) for i in input().split()]
    for r in range(n//2-1,0,-1):
        if data[r] != data[r+1] and data[r] != data[n//2]:
            break
    else:
        print("0 0 0")
        continue
    #print(r)

    for g in range(1,r+1):
        if data[g] != data[g-1]:
            break
    else:
        print("0 0 0")
        continue
    # g = number of gold medals

    for s_idx in range(2*g,r+1):
        if data[s_idx+1] != data[s_idx]:
            break
    else:
        print("0 0 0")
        continue
    
    k = r + 1
    s_min = s_idx + 1 - g
    
    if k - s_min - g > g:
        print(str(g)+ " " + str(s_min) + " " + str(k-s_min-g))
    else:
        print("0 0 0")



    

