n = input()


for i in range(int(n)):
    a = int(input())
    li = []
    li = input().split()
    if int(li[0]) + int(li[1]) <= int(li[a-1]):
        print(str(1) + " " + str(2) + " " + str(a))
    else:
        print("-1")
