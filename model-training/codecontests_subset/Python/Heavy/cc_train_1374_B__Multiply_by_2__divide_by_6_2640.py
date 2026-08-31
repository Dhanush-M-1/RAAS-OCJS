def main():
    for t in range(int(input())):
        x = int(input())
        ansFound = False
        # print("T", t)
        moves = 0
        while(x > 1):
            if x % 6 == 0:
                x = x // 6
                moves += 1
            else:
                if x % 3 != 0:
                    print(-1)
                    ansFound = True
                    break
                else:
                    x *= 2
                    moves += 1
        if not ansFound:
            print(moves)
main()