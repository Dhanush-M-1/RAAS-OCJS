c = int(input())
for i in range(c):
    hand=0
    stones = list(map(int, input().split()))
    while (stones[1] > 1 and stones[0] > 0) or (stones[2] > 1 and stones[1] > 0):
        if stones[2] > 1 and stones[1] > 0:
            if stones[1]*2 >= stones[2]:
                hand += stones[2] // 2
                stones[1] -= stones[2] // 2
                hand += stones[2]//2 * 2
                stones[2] = stones[2] % 2
            elif stones[1]*2 <= stones[2]:
                hand += stones[1]*3
                stones[1] -= stones[1]
        elif stones[1] > 1 and stones[0] > 0:
            if stones[0]*2 >= stones[1]:
                hand += stones[1] // 2
                stones[0] -= stones[1] // 2
                hand += stones[1]//2 * 2
                stones[1] = stones[1] % 2
            elif stones[0]*2 <= stones[1]:
                hand += stones[0]*3
                stones[0] -= stones[0]
    print(hand)