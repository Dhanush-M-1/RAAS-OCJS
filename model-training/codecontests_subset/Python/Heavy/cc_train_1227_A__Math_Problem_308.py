t = int(input()) # количество наборов входных данных в тесте
lengths = []
for i_t in range(t):
    n = int(input())
    for i_n in range(n):
        left, right = input().split()
        left = int(left)
        right = int(right)
        if i_n == 0:
            left_common = left
            right_common = right
            flag = True
        else:
            if flag:
                if left_common < left < right_common:
                    left_common = left
                if left_common < right < right_common:
                    right_common = right
                if right == left_common:
                    flag = False
                    left_common = right_common = right
                elif right < left_common:
                    flag = False
                    right_common, left_common = left_common, right
                if left == right_common:
                    flag = False
                    left_common = right_common = left
                elif right_common < left:
                    flag = False
                    left_common, right_common = right_common, left
            else:
                if left_common > right:
                    left_common = right
                if right_common < left:
                    right_common = left
    if flag:
        lengths.append(0)
    else:
        lengths.append(right_common - left_common)
for length in lengths:
    print(length)
