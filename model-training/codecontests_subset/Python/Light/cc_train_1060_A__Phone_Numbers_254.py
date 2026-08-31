def find_eights():
    sum = 0
    for i in range(len(y)):
        if y[i] == "8":
            sum += 1
    return sum



k = int(input())
y = input()
find_e = find_eights()
ll = k // 11

if k < 11 or find_e == 0:
    print(0)
    exit()

if (find_e >= ll):
    print(ll)
else:
    print(find_e)
    