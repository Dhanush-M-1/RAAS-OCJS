(a, b) = input().split(' ')
(a, b) = (int(a), int(b))
used = a
not_used = 0
hours = 0
while used != 0:
    hours += used
    not_used += used
    used = not_used // b
    not_used = not_used % b

print(hours)
