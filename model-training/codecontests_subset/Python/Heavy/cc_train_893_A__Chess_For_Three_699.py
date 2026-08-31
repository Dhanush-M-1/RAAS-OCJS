n = int(input())
l = n
player = ["Alex", "Bob", "Carl"]
current = ["Alex", "Bob"]
count = 0
i = 0
while n:
    a = int(input())
    if a == 1 and 'Alex'in current:
        if 'Bob' in current:
            current[1] = 'Carl'
        else:
            current[1] = 'Bob'
        current[0] = 'Alex'
        count += 1
    elif a == 2 and 'Bob' in current:
        if 'Alex' in current:
            current[1] = 'Carl'
        else:
            current[1] = 'Alex'
        current[0] = 'Bob'
        count += 1
    elif a == 3 and 'Carl' in current:
        if 'Bob' in current:
            current[1] = 'Alex'
        else:
            current[1] = 'Bob'
        current[0] = 'Carl'
        count += 1
    n -= 1

print("YES" if count == l else "NO")