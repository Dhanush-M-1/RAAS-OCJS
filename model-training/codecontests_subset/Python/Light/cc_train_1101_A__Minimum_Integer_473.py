n = int(input())

for i in range(n):
    s = input().split(' ')
    if int(s[2]) < int(s[0]):
        print(int(s[2]))
    else:
        print(int(s[2]) * (int(s[1])//int(s[2]) + 1))