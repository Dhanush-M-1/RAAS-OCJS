n, k = map(int, input().split(" "))
lengths = map(int, input().split(" "))

min_hours = k

for l in lengths:
    if k % l == 0:
        hours = int(k / l)
        if hours < min_hours:
            min_hours = hours

print(min_hours)