tc = int(input())
for i in range(tc):
    n = int(input())
    p = list(map(int, input().split()))
    tracker = [1]
    for k in range(1, n):
        if p[k]==p[k-1]:
            tracker[-1] +=1
        else:
            tracker.append(1)
    half = n//2
    g,s,b=0,0,0
    possible = []
    total = 0
    for k in tracker:
        if total+k<=half:
            possible.append(k)
            total += k
        else:
            break
    if len(possible) < 3:
        print("0 0 0")
    else:
        g=possible[0]
        sumpos = sum(possible[1:])
        total = 0
        found = False
        for k in possible[1:]:
            if total+k>possible[0] and sumpos-(total+k)> possible[0]:
                print(possible[0], total+k, sumpos-(total+k))
                found=True
                break
            total+=k
        if not found:
            print("0 0 0")