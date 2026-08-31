day_now = input().split()
n = int(input())

print(day_now[0], day_now[1])

for i in range(n):
    change = input().split()
    day_now[day_now.index( change[0] )] = change[1]
    print(day_now[0], day_now[1])