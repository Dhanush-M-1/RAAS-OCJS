person = input().split()
print(*person)
for i in range(int(input())):
    a, b = input().split()
    person.remove(a)
    person.append(b)
    print(*person)
