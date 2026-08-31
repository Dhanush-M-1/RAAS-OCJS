for _ in range(int(input())):
    n = int(input())
    first = input().split()
    plays, clears = int(first[0]), int(first[1])
    possible = True
    if clears > plays:
        possible = False
    for i in range(n - 1):
        value = input().split()
        current_plays, current_clears = int(value[0]), int(value[1])
        if possible:
            if current_clears - clears > current_plays - plays or current_plays < plays or current_clears < clears:
                possible = False
        plays, clears = current_plays, current_clears
    if possible:
        print("YES")
    else:
        print("NO")
