t = int(input())

for _ in range(t):
    mat = []
    n = int(input())
    for _ in range(n):
        mat.append(input())
    start1 = mat[0][1]
    start2 = mat[1][0]
    end1 = mat[n-1][n-2]
    end2 = mat[n-2][n-1]
    # if start1 == '0' and start2 == '0':
    #     if end1 == '1' and end2 == '1':
    #         print(0)
    #         continue
    #     if end2 == '1' and end2 == '0':
    #         print(1)
    #         print(n-2, n-1)
    #         continue
    #     if end2 == '0' and end2 == '1':
    #         print(1)
    #         print(n-1, n-2)
    ans = 0
    changes= []
    if start1 != start2:
        if end1 == end2:
            if start1 == end1:
                ans+=1
                changes.append([0, 1])
            else:
                ans += 1
                changes.append([1,0])
        elif start1 != end1:
            ans += 2
            changes.append([0,1])
            changes.append([n-1, n-2])
        else:
            ans += 2
            changes.append([1,0])
            changes.append([n-1, n-2])
    else:
        if start1 != end1 and start2 != end2:
            print(0)
            continue
        if start1 == end1 and start2 != end2:
            ans += 1
            changes.append([n-1, n-2])
        elif start1 != end1 and start2 == end2:
            ans += 1
            changes.append([n-2, n-1])
        else:
            ans += 2
            changes.append([n-1, n-2])
            changes.append([n-2, n-1])
        
    print(ans)
    for line in changes:
        print(int(line[0]) + 1, int(line[1]) + 1)