num_test_cases = int(input())
test_cases = []
for test in range(num_test_cases):
    test_case = []
    num_records = int(input())
    test_case.append(num_records)
    list_records = []
    for record in range(num_records):
        list_records.append([int(element) for element in input().split()])
    test_case.append(list_records)
    test_cases.append(test_case)

for test in test_cases:
    result = "YES"
    rec_list = test[1].copy()
    p_ = 0
    c_ = 0
    for i in range(test[0]):
        p = rec_list[i][0]
        c = rec_list[i][1]
        if p_ > p or c_ > c or c > p or (c - c_) > (p - p_):
            result = "NO"
        p_ = p
        c_ = c
    print(result)
