person1, person2 = map(str, input().split())
Amt_days = int(input())
Potential = []
Potential.append(person1)
Potential.append(person2)
Alive = ''
print(*Potential)
for i in range(Amt_days):
    person1, person2 = map(str, input().split())
    for i in range(2):
        if Potential[i] == person1:
            Potential[i] = person2
            break
    print(*Potential)
