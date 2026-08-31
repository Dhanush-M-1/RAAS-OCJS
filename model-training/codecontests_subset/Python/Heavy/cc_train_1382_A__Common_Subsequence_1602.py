if __name__ == '__main__':
    t = int(input())
    for h in range(t):
        len_list = list(map(int, input().split()))
        list_1 = list(map(int, input().split()))
        list_2 = list(map(int, input().split()))
        set_1  = set(list_1)
        set_2  = set(list_2)
        # print(set_1)
        # print(set_2)
        diff = set_1 & set_2
        # print(diff)
        diff_list = list(diff)
        # print(diff_list)
        if len(diff_list) !=0:
            print("YES")
            print("1", end = " ")
            print(diff_list[0])
        else:
            print("NO")