# http://codeforces.com/contest/268/problem/A

def solution(teams, n):
    result = 0

    for i in range(n):
        host_color = teams[i][0]
        for j in range(n):
            if i == j:
                continue

            guest_color = teams[j][1]
            if host_color == guest_color:
                result += 1

    return result

if __name__ == "__main__":
    n = int(input())
    teams = []
    for _ in range(n):
        inp = list(map(int, input().split()))
        teams.append(inp)
    print(solution(teams, n))