num = int(input())
string = input()
num = int(num)

max_count = 0
max_str = ""

grams = []
for i in range(len(string)-1):
    found = False
    a_string = string[i] + string[i+1]
    if len(grams) == 0:
            grams.append([a_string, 1])
    else:
        for j in grams:
            if j[0] == a_string:
                j[1] += 1
                found = True
                break
        if not found:
            grams.append([a_string, 1])

for item in grams:
    if item[1] >= max_count:
        max_count = item[1]
        max_str = item[0]
print(max_str)