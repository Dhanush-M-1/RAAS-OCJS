name1, name2 = map(str, input().split())
n = int(input())
victims = []
next_victims = []
for i in range(n):
    v_name, replaced_v = map(str, input().split())
    victims.append([v_name, replaced_v])

print(name1, name2)
count_lines =0
for x in victims:

    if x[0] == name1 and count_lines < n:
        x[0] = x[1]
        x[1] = name2
        print(x[0], x[1])
        count_lines += 1
    if x[0] == name2 and count_lines < n:
        x[0] = name1
        print(x[0], x[1])
        count_lines += 1
    for i in range(len(victims) - 1):
        if x[1] == victims[i + 1][0] and count_lines < n:
            victims[i + 1][0] = x[0]
            x[1] = victims[i + 1][1]
            next_victims.append([victims[i + 1][0], x[1]])
            if x[0] == x[1]:
                break
            print(victims[i + 1][0], x[1])
            count_lines += 1
        elif x[0] == victims[i + 1][0] and count_lines < n:
            x[0] = victims[i + 1][1]
            next_victims.append([x[0], x[1]])
            if x[0] == x[1]:
                break
            print(x[0], x[1])
            count_lines += 1
