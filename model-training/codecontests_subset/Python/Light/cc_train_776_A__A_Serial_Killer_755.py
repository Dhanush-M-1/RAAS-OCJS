victims = set(input().split())
print(*victims)

for _ in range(int(input())):
    casualty, new_victim = input().split()
    victims.discard(casualty)
    victims.add(new_victim)
    print(*victims)