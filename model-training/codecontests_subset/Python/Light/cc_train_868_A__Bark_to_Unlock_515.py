Password = input()
Looper = int(input())
Bark = []
Flag = False
for i in range(Looper):
    Bark.append(input())
    if Bark[-1] == Password:
        Flag = True
        Looper = 0
        break
for i in range(Looper):
    for j in range(Looper):
        if Bark[i][1] + Bark[j][0] == Password:
            Flag = True
            break
print("YES" if Flag else "NO")