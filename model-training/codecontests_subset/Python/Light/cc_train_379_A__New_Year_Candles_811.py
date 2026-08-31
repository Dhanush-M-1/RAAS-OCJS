a, b = [int(i) for i in input().split()]
hours = a
sub = a
remain = 0
while (sub + remain) // b > 0:
    curr = sub
    sub = (sub + remain) // b
    remain = (curr + remain)% b
    hours += sub

print(hours)