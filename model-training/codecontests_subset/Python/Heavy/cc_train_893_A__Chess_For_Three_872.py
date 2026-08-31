n = int(input())
array = []
c = 0
for i in range(n):
    array.append(int(input()))
if array[0] == 1:
    winner = 1
    loser = 2
elif array[0] == 2:
    winner = 2
    loser = 1
else:
    c = -1
    n = 1
    print("NO")
spect = 3
for i in range(n-1):
    a = array[i + 1]
    if loser == a:
        print("NO")
        c = -1
        break
    elif winner == a:
        b = loser
        loser = spect
        spect = b
    else:
        b = winner
        winner = spect
        spect = loser
        loser = b
if c == 0:
    print ("YES")