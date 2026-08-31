n = int(input())
table = [1,2]
done=0
for x in range(n):
    winner=int(input())
    if not done:
        if winner not in table:
            done = 1
        if winner == 1:
            if 2 in table:
                table = [1,3]
            else:
                table = [2,1]
        elif winner ==2:
            if 1 in table:
                table = [2,3]
            else:
                table = [1,2]
        else:
            if 2 in table:
                table = [1,3]
            else:
                table = [2,3]

if done:
    print("NO")
else:
    print("YES")
    