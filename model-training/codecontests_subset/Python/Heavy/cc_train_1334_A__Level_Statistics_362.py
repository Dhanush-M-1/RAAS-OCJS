
def soln(stats):
    for plays, clears in stats:
        if clears > plays:
            return False
    for i in range(len(stats) - 1):
        clearDiff = stats[i + 1][1] - stats[i][1]
        if not (
            stats[i + 1][0] - stats[i][0] >= clearDiff and
            all( stats[i + 1][j] >= stats[i][j] for j in range(2) )
        ):
            return False
    return True

def main():
    T = int(input())
    for _ in range(T):
        n = int(input())
        stats = []
        for _ in range(n):
            stats.append([int(x) for x in input().split(" ")])
        print("YES" if soln(stats) == True else "NO")

def test():
    stats = [
        
    ]

if __name__ == "__main__":
    main()