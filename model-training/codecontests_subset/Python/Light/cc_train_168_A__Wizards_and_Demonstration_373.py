n, x, y = map(int, input().split())

people = n * y / 100
if not people.is_integer():
    people = int(people) + 1
else:
    people = int(people)

if people < x:
    print(0)
else:
    print(people - x)