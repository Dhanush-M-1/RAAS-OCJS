for t in range(int(input())):
    n = int(input())
    medals = [0, 0, 0]
    solved_prob = list(map(int, input().split()))
    positions = []
    for i in range(n // 2):
        if solved_prob[i] != solved_prob[i + 1]:
            positions.append(i + 1)
    if len(positions) < 3:
        print(*medals)
        continue
    else:
        x = positions[0]
        medals[0] = x
        positions = positions[1:]
        positions = [y - x for y in positions]
        for i, x in enumerate(positions):
            if x > medals[0]:
                medals[1] = x
                positions = positions[i + 1:]
                positions = [y - x for y in positions]
                break
        if len(positions) < 1:
            print('0 0 0')
            continue
        else:
            if positions[-1] > medals[0]:
                medals[2] = positions[-1]
                print(*medals)
            else:
                print('0 0 0')
