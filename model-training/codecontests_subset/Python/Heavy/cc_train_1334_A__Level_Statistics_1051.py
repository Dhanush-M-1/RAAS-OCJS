"""
isVerbose = False
def verbosity(msg):
    if isVerbose:
        print(msg)
"""

results = []

num_test_cases = int(input())
for test_case in range(num_test_cases):
    num_obs = int(input())
    obs_lst = []
    for obs in range(num_obs):
        obs_lst.append(list(map(int, input().split())))

    if len(obs_lst) == 1:
        if obs_lst[0][1] > obs_lst[0][0]:
            results.append("No")
            continue
        else:
            results.append("Yes")
            continue

    ply_lst = []
    clr_lst = []
    for obs in obs_lst:
        ply_lst.append(obs[0])
        clr_lst.append(obs[1])

    # erstes Paar muss passen
    if ply_lst[0] < clr_lst[0]:
        results.append("No")
        continue

    # diff muss passend wachsen
    ply_diff_lst = []
    clr_diff_lst = []
    for index in range(len(ply_lst) -1):
        ply_diff_lst.append(ply_lst[index+1] - ply_lst[index])
        clr_diff_lst.append(clr_lst[index+1] - clr_lst[index])

    if min(ply_diff_lst) < 0 or min(clr_diff_lst) < 0:
        results.append("No")
        continue

    diffs_passen = True
    for index in range(len(ply_diff_lst)):
        if clr_diff_lst[index] > ply_diff_lst[index]:
            diffs_passen = False
            break

    if not diffs_passen:
        results.append("No")
        continue

    results.append("Yes")
   
print(*results, sep="\n")









        
