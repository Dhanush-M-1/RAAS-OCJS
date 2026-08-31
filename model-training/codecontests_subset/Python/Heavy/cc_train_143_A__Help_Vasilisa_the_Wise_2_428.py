lock = [[0,0],[0,0]]
r1,r2 = map(int,input().split())
c1,c2 = map(int,input().split())
d1,d2 = map(int,input().split())
for i in range(1,10):
    lock[0][0] = i
    lock[0][1] = r1 -i
    lock[1][0] = c1 - lock[0][0]
    lock[1][1] = r2 - lock[1][0]
    if lock[0][0] + lock[0][1] == r1 \
            and lock[1][0] + lock[1][1] == r2\
            and lock[0][0] + lock[1][0] == c1 \
            and  lock[0][1] + lock[1][1] == c2 \
            and lock[0][0] + lock[1][1] == d1 \
            and lock[1][0]+ lock[0][1] == d2:
        if len(set(lock[1]).union(lock[0]))  == 4 and (0< lock[0][0] <=9)and (0< lock[0][1] <=9) and (0< lock[1][1] <=9) and (0< lock[1][0] <=9):
            print(lock[0][0] ,lock[0][1])
            print(lock[1][0], lock[1][1])
            break
    if i ==9:
        print(-1)
