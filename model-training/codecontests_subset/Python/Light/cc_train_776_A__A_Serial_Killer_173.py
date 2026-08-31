victims = input().split()
n = int(input())
print(*victims)
for i in range(n):
    killed, victim = input().split()
    victims.remove(killed)
    victims.append(victim)
    print(*victims)

















