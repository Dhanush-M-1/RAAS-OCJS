potential_victim_1, potential_victim_2 = input().split()
print(potential_victim_1, potential_victim_2)
n = int(input())
for i in range(n):
    victim, next_potential_victim = input().split()
    if potential_victim_1 == victim:
        print(potential_victim_2, next_potential_victim)
        potential_victim_1 = next_potential_victim
    else:
        print(potential_victim_1, next_potential_victim)
        potential_victim_2 = next_potential_victim
        