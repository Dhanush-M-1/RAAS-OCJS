def solve(stats):
    plays = 0
    clears = 0
    for i, stat in enumerate(stats):
        plays += stat[0]
        clears += stat[1]
        if i > 0:
            if stats[i][0] < stats[i-1][0]:
                return False
            if stats[i][1] < stats[i-1][1]:
                return False
            new_plays = stats[i][0] - stats[i-1][0]
            new_clears = stats[i][1] - stats[i-1][1]
            if new_plays < new_clears:
                return False
        if plays < clears:
            return False
    return True


if __name__ == "__main__":
    for i in range(int(input())):
        stats = [[int(x) for x in input().split()] for x in range(int(input()))]
        print("YES" if solve(stats) else "NO")
