
def create_matches(teams):
    matches = []
    for k in range(len(teams)):
        teams[k], teams[0] = teams[0], teams[k]
        for i in range(1,len(teams)):
            matches.append([teams[0],teams[i]])
    return matches


def host_guest_switches(matches):
    count = 0
    for match in matches:
        team_1 = match[0]
        team_2 = match[1]
        if team_1[0] == team_2[1]:
            count += 1
    return count


def main():
    n = int(input())
    teams = []
    for i in range(n):
        teams.append([int(i) for i in input().split()])
    matches = create_matches(teams)
    count = host_guest_switches(matches)
    print(count)



main()

