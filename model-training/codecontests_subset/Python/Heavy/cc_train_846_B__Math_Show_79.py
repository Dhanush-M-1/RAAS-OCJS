def solve(n, k, M, t):
    task_sum = sum(t)
    t = sorted(t)  # will take from smaller subtasks

    all_points = []
    for tasks_completed in range(n + 1):  # loop over tasks fully taken from 0 to N taken tasks
        minutes_spent_on_full_tasks = tasks_completed * task_sum
        if minutes_spent_on_full_tasks > M:
            break

        # k subtasks + 1 for each
        total_points = tasks_completed * k + tasks_completed
        remaining_time = M - minutes_spent_on_full_tasks

        for subtask_time in t:  # loop over subtasks
            # try take all smaller subtasks from remaining unsolved tasks
            # don't count in fully completed tasks
            subtasks_left = n - tasks_completed
            smaller_subtasks_time = subtasks_left * subtask_time  # total "weight" of all left subtasks for given time group

            if (smaller_subtasks_time <= remaining_time): # can take entire set of subtasks with given weight
                remaining_time -=  smaller_subtasks_time
                total_points += subtasks_left # simply add all subtasks of given t[i]
            else:  # cannot take entire set, lets take at least "tail"
                total_points += remaining_time // subtask_time
                break  # no time left

        all_points += [total_points]
    return max(all_points)








def main():
    n, k, M = [int(x) for x in input().split(" ")]
    t = [int(x) for x in input().split(" ")]
    # n, k, M = 4, 2, 15
    # t = [1, 2, 4, 8, 16]
    # t = [1, 1, 1, 1]
    # t = [4, 1]
    res = solve(n, k, M, t)

    print(res)


if __name__ == '__main__':
    main()
