def problem_sol(n, arr_field):
    num_changes = 0
    sol_list = []
    s_right = int(arr_field[0][1])
    s_down = int(arr_field[1][0])
    f_left = int(arr_field[n - 1][n - 2])
    f_up = int(arr_field[n - 2][n - 1])
    if f_left == f_up:
        if f_left == s_right:
            sol_list.append('1 2')
            num_changes += 1
        if f_left == s_down:
            sol_list.append('2 1')
            num_changes += 1
    elif s_right == s_down:
        if s_right == f_left:
            sol_list.append(str(n) + ' ' + str(n - 1))
            num_changes += 1
        if s_right == f_up:
            sol_list.append(str(n - 1) + ' ' + str(n))
            num_changes += 1
    else:
        if f_left == 1:
            sol_list.append(str(n) + ' ' + str(n - 1))
            num_changes += 1
        else:
            sol_list.append(str(n - 1) + ' ' + str(n))
            num_changes += 1
        if s_right == 0:
            sol_list.append('1 2')
            num_changes += 1
        else:
            sol_list.append('2 1')
            num_changes += 1
    print(num_changes)
    for entry in sol_list:
        print(entry)


no_inp = int(input())
list_of_var1 = []
while no_inp > 0:
    n = int(input())
    arr_field = [input() for i in range(n)]
    list_of_var1.append([n, arr_field])
    no_inp -= 1
for entry in list_of_var1:
    problem_sol(entry[0], entry[1])