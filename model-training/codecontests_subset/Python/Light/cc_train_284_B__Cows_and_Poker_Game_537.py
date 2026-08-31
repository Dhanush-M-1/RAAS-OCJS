n = int(input())
table = input()

if table.count("I") > 1 :
    print(0)
elif table.count("I") == 1 :
    print(1)
else:
    print(table.count("A"))