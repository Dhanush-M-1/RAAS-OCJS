t = int(input())

for x in range(t):
    stones = list(map(int, input().split()))
    alice_stones = 0
    first_heap_stones = stones[0]
    last_heap_stones = stones[2]
    while stones[1] != 0:
        if stones[1] > 0 and stones[2] >= 2:
            stones[1] -= 1
            stones[2] -= 2
            alice_stones += 3
        elif stones[0] > 0 and stones[1] >= 2:
            stones[0] -= 1
            stones[1] -= 2
            alice_stones += 3
        else:
            break
    print(alice_stones)