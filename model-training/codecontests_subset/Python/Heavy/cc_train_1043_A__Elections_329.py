def main():
    num = input()
    # Get the input list.
    temp_list = input().split(" ")

    main_list = []
    # Make another list to convert all list elements to <int> type.
    for i in range(len(temp_list)):
        main_list.append(int(temp_list[i]))


    add = sum(main_list)
    k = max(main_list)
    test_list = []
    z = 0
    while add >= z:
        for i in range(len(main_list)):
            test_list[:] = [(k - j) for j in main_list]
            z = sum(test_list)
        k += 1

    print(k - 1)








if __name__ == "__main__":
    main()