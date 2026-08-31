pw = input()
f = 1
n = int(input())
for a in range(0, n):
    bark = input()
    if(bark[1] == pw[0]):
        f = f * 2
    if(bark[0] == pw[1]):
        f = f * 3
    if(bark == pw):
        f = 6

if(f%6 == 0):
    print("YES")
else:
    print("NO")