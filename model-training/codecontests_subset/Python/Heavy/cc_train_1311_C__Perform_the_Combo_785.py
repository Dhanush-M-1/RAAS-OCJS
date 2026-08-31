t = int(input())

for i in range(t):
    line = input()
    [n, m] = [int(x) for x in line.split(' ')]

    s = input()
    
    line = input()
    p = [int(x) for x in line.split(' ')]
    # print(p)

    pressed = [0] * 26

    sums = [0] * n

    for pi in p:
        sums[pi-1] += 1
    
    for i in range(n-2, -1, -1):
        sums[i] = sums[i] + sums[i+1]

    # print(sums)


    for index, si in enumerate(s):
        pressed[ord(si) - ord('a')] += sums[index]

    for index, si in enumerate(s):
        pressed[ord(si) - ord('a')] += 1


    for x in pressed:
        print(str(x) + ' ', end='')
    print()
