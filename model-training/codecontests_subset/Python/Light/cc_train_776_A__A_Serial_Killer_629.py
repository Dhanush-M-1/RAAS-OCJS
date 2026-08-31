name1, name2 = input().split()
i = int(input())
c = 0
while c < i and 0 <= i <= 1000:
    print(name1, name2)
    name3, name4 = input().split()
    if name1 == name3 or name1 == name4:
        name1 = name4
    if name2 == name4 or name2 == name3:
        name2 = name4
    c += 1
    if c >= i:
        print(name1, name2)
