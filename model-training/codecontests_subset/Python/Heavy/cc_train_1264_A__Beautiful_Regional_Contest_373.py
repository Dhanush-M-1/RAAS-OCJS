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

    for b_idx in range(r-g,g-1,-1):
        if data[b_idx] != data[b_idx-1]:
            break
    else:
        print("0 0 0")
        continue
    
    k = r + 1
    s_min = s_idx + 1 - g
    b_min = r - b_idx + 1
    
    #Case 1 s_min is OK
    if k - s_min - g > g:
        print(str(g)+ " " + str(s_min) + " " + str(k-s_min-g))
    elif k - b_min - g > g:
        print(str(g) + " "+ str(k - b_min - g) + " " + str(b_min))
    else:
        print("0 0 0")



    

