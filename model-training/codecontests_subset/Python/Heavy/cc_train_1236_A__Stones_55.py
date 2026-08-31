
def stones(stonepile):
    count = 0
    while (stonepile[0] >= 1 and stonepile[1] >= 2) or (stonepile[1] >= 1 and stonepile[2] >= 2):
        if stonepile[1] > stonepile[2] // 2 and (stonepile[0] >= 1 and stonepile[1] >= 2):
            stonepile[0] -= 1
            stonepile[1] -= 2
            count += 3
        else:
            stonepile[1] -= 1
            stonepile[2] -= 2
            count += 3
    return count

t = int(input())
for i in range(t):
    arr = list(map(int, input().split()))
    print(stones(arr))