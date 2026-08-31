a, b = map(int, input().split())
ans = a
burnt = 0
hours = 0
while ans > 0 or burnt >= b:
    ans = ans - 1
    burnt = burnt + 1

    if burnt > b:
        burnt = burnt - b
        ans = ans + 1
        
    hours = hours + 1

print(hours)
