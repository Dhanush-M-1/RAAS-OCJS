n, m = map(int,input().split())
student_list = [list(map(int,input().split())) for _ in range(n)]

check_list = [list(map(int,input().split())) for _ in range(m)]

for s in student_list:
    tmp = []
    for c in check_list:
        tmp.append(abs(s[0]-c[0]) + abs(s[1]-c[1]))
    print(tmp.index(min(tmp))+1)