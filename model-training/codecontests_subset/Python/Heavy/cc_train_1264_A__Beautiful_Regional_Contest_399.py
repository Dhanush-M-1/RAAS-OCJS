for case in range(int(input())):
    n = int(input())
    problem_solved_dict = {}
    problems_solved_sequence = [int(x) for x in input().split()]
    for x in problems_solved_sequence:
        try:
            problem_solved_dict[x] += 1
        except KeyError:
            problem_solved_dict[x] = 1

    medals = []
    can_be_awarded = 0
    diffrent_score = 0
    awardable_score_frequency = []
    if n <= 5:
        print('0 0 0')
        continue
    else:
        for key in problem_solved_dict.keys():
            temp = can_be_awarded + problem_solved_dict[key]
            if temp > n // 2:
                break
            else:
                diffrent_score += 1
                can_be_awarded += problem_solved_dict[key]
                awardable_score_frequency.append(problem_solved_dict[key])

    if diffrent_score < 3:
        print('0 0 0')
        continue

    gold = awardable_score_frequency[0]
    silver = 0
    for x in awardable_score_frequency[1:diffrent_score]:
        silver += x
        if silver > gold:
            break
    bronze = sum(awardable_score_frequency) - silver - gold
    if bronze == 0 or gold >= bronze:
        print('0 0 0')
    else:
        print("{} {} {}".format(gold, silver, bronze))


