names = input().split()
n = int(input())

print(names[0] + ' ' + names[1])

for i in range(n):
    victims = input().split()
    names = list(set(victims + names) - set(victims).intersection(names))
    print(names[0] + ' ' + names[1])