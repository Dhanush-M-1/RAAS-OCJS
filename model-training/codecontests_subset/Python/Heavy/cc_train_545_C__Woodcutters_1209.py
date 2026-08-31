if __name__ == '__main__':    
    
    n = int(input())
    place = []
    tree = []
    for i in range(n):
        next = input().split()
        place.append(int(next[0]))
        tree.append(int(next[1]))
    
    greedy = 1
    occupied = False
    index = 1
    while index < n-1:
        if not occupied and place[index - 1] + tree[index] < place[index]:
            greedy += 1
        elif occupied and place[index - 1] + tree[index - 1] + tree[index] < place[index]:
            greedy += 1
            occupied = False
        elif place[index] + tree[index] < place[index + 1]:
            greedy += 1
            occupied = True
        else:
            occupied = False
        index += 1
    if n > 1:
        greedy += 1
    
    print(greedy)