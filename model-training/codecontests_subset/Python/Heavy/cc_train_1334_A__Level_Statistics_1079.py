case_id = 0
test_results = []

# t = int(input("Please enter number of test cases: "))
t = int(input())
for i in range(1, t+1):
    n = int(input())
    test_cases = []

    for i in range(1, n+1):
        # for each n ask for new input of pi and ci
        test_case=[int(x) for x in input().split(" ")]
        test_cases.append(test_case)

    # validate test case
    for case_id in range(n):
        # print(test_cases[case_id])
        # check if number of plays >= number of clears
        if test_cases[case_id][0] < test_cases[case_id][1]:
            test_results.append("NO")
            break
        # if it is not the last case then check subsequent p and c
        elif case_id+1 != n:
            if test_cases[case_id][0] > test_cases[case_id+1][0] or test_cases[case_id][1] > test_cases[case_id+1][1]:
                test_results.append("NO")
                break
            elif test_cases[case_id][0] == test_cases[case_id+1][0]  and test_cases[case_id][1] != test_cases[case_id+1][1]:
                test_results.append("NO")
                break
            elif test_cases[case_id+1][1] - test_cases[case_id][1] > test_cases[case_id+1][0] - test_cases[case_id][0]:
                test_results.append("NO")
                break                                   
    else:  test_results.append("YES")

for i in test_results:
    print(i)