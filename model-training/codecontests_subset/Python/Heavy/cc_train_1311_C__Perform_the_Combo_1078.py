def char_position(letter):
    return ord(letter) - 97


t = int(input())
for i in range(t):
    n, m = [int(x) for x in input().split()]
    s = input()
    p = [int(x) for x in input().split()]
    result = [0]*26
    count = [0]*n

    # indicate which letter needs to "redo"
    for pos in p:
        #charPos = char_position(s[pos-1])
        count[pos-1] += 1

    #
    for j in range(n-1, 0, -1):
        count[j-1] += count[j]

    for j in range(n):
        charPos = char_position(s[j])
        result[charPos] += count[j] + 1

    print(*result, sep=' ')
