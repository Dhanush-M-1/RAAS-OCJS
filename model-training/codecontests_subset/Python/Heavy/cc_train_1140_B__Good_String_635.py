t = int(input())

for _ in range(t):
    n = int(input())
    char_list = input()
    num_to_rem = 0
    if char_list[0] == '>' or char_list[-1] == '<':
        print(0)
    else:
        count_from_left = 0
        for i in range(n):
            if char_list[i] == '>':
                break
            count_from_left += 1
        
        count_from_right = 0
        for i in range(n - 1, -1, -1):
            if char_list[i] == '<':
                break
            count_from_right += 1
        
        print(min(count_from_left, count_from_right))

        