import time

def pickUniforms(hostUni, guestUnifs):
    dupl = 0
    hUnif = hostUni[0]
    for guestUnif in guestUnifs:
        gUnif = guestUnif[1]
        if hUnif == gUnif:
            dupl += 1
    return dupl

def solve():
    teams = int(input())
    games = teams * (teams-1)
    teamUnifsMat = []
    for x in range(teams):
        teamUnif = [int(x) for x in input().split()]
        teamUnifsMat.append(teamUnif)
    start_time = time.time()

    qtyDupl = 0

    for inx, y in enumerate(teamUnifsMat):
        qtyDupl += pickUniforms(y, teamUnifsMat)
    print(qtyDupl)
    # print("%fs" % (time.time() - start_time))



solve()