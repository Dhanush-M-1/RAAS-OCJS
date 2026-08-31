X = input()
N = int(input())
First, Second = False, False
for i in range(N):
    Temp = input()
    if X == Temp:
        print("YES")
        exit()
    if X[0] == Temp[1]:
        First = True
    if X[1] == Temp[0]:
        Second = True
    if First and Second:
        print("YES")
        exit()
print("NO")
