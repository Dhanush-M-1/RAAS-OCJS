nm = input()
nm = nm.split(" ")

data = [input().split(" ") for i in range(int(nm[0]))]

bulbs = list()
for btn in data:
    btn.pop(0)
    for bulb in btn:
        bulbs.append(int(bulb))
if list(set(bulbs))==list(range(1, int(nm[1])+1)):
    print("YES")
else:
    print("NO")
