no_test = int(input())
for i in range(0, no_test):
    moment = int(input())
    preplays, preclear = -1, -1
    result = 'Yes'
    for j in range(0, moment):
        plays, clears = input().split(' ')
        plays = int(plays)
        clears = int(clears)
        if plays >= clears and ((plays > preplays and (clears in range(preclear, preclear+plays-preplays+1))) or (plays==preplays and clears==preclear)):
            preplays, preclear = plays, clears
        else:
            result = 'No'
    print(result)