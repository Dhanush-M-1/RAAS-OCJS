for _ in range(int(input())):
    N = int(input())
    Last = list(map(int, input().split()))
    Countinue = False
    if Last[1] > Last[0]:
        Countinue = True
    for i in range(N - 1):
        Temp = list(map(int, input().split()))
        Check = Temp[0] - Last[0]
        if Countinue == False:
            if Temp[0] == Last[0] and Temp[1] != Last[1]:
                Countinue = True
            if Check < 0 or Temp[1] - Last[1] < 0 or Temp[1] - Last[1] > Check:
                Countinue = True
        Last = Temp[:]
    if Countinue:
        print("NO")
    else:
        print("YES")

# Target -----> Specialist for now
# Hope the best for Ravens member
