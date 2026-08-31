def NO(): return print("NO")
def YES(): return print("YES")
def INT(): return int(input())
def LIST(): return list(map(int, input().split()))
def STR(): return input()
def MAP(): return map(int, input().split())

for _ in range(INT()):
    n = INT()
    tries = []
    won = []
    check = False
    for i in range(n):
        p, c = MAP()
        tries.append(p)
        won.append(c)
    if n == 1:
        buff = tries[i]
        wins = won[i]
        if wins > buff: 
            NO()
            check = True
    else:
        for i in range(n-1):
            buff = tries[i]
            wins = won[i]
            if buff > tries[i+1] or wins > buff or (tries[i+1] - buff < won[i+1] - wins) or won[i+1] < wins or tries[i+1] < buff:
                NO()
                check = True
                break
    if not check: YES()