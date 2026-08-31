t = int(input())

for case in range(t):
    n = int(input())
    data = []
    
    for line in range(n):
        plays, clears = map(int, input().split())
        data.append((plays, clears))

    last_plays = -1
    last_clears = -1

    for plays, clears in data:
        if last_plays > plays or last_clears > clears or clears > plays or (last_plays - last_clears) > (plays - clears):
            print("NO")
            break

        last_plays = plays
        last_clears = clears
    else:
        print("YES")
