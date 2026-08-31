testcases = int(input())

for i in range(testcases):
    m, n = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    freq_dict_a, freq_dict_b = {}, {}

    for ele in a:
        if ele not in freq_dict_a:
            freq_dict_a[ele] = 1

    for ele in b:
        if ele not in freq_dict_b:
            freq_dict_b[ele] = 1

    got_it = False

    for key in freq_dict_a.keys():
        if key in freq_dict_b:
            print("YES")
            print(1, key)
            got_it = True
            break

    if not got_it:
        print("NO")