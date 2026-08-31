t = int(input())
for _ in range(t):
    n = int(input())
    p = [int(x) for x in input().split()]
    
    if n < 6:
        print('0 0 0')
        continue

    anchor = n//2
    x = p[anchor]
    for i in range(anchor-1, 0, -1):
        if p[i] != x:
            anchor = i
            break
    prev = 1
    medals = [1,0,0]
    for i in range(1, anchor+1):
        if p[i] == p[i-1]:
            medals[prev-1]+=1
        elif prev == 1:
            prev = 2
            medals[1]+=1
        elif prev == 2 and medals[0] >= medals[1]:
            prev = 2
            medals[1]+=1
        elif prev == 2 and medals[0] < medals[1]:
            prev = 3
            medals[2]+=1
        elif prev == 3:
            medals[2]+=1
    
    if medals[0] < 1 or medals[1] < 1 or medals[2] < 1:
        print('0 0 0')
        continue
    if medals[0] >= medals[2]:
        print('0 0 0')
        continue
    print(medals[0], medals[1], medals[2])
