tests = int(input())

for t in range (tests):
    length = int(input())
    string = input()

    right_pos = -1
    left_pos = -1

    for i in range (len(string)):
        if string[i] == ">":
            right_pos = i
            break

    for j in range(len(string)-1, -1, -1):
        if string[j] == "<":
            left_pos = j
            break

    if left_pos == -1 or right_pos == -1:
        print(0)
        continue

    if left_pos == (len(string)-1) or right_pos == 0:
        print(0)
        continue

    if len(string) - left_pos > right_pos:
        print(right_pos)
        continue
    else:
        print(length-left_pos-1)

