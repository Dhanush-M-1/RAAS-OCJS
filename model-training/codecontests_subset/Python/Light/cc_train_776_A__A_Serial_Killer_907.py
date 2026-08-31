victim1, victim2 = input().split()
print(victim1, victim2)
for _ in range(int(input())):
	mudered, next = input().split()
	if mudered == victim1:
		victim1 = next
	else:
		victim2 = next
	print(victim1, victim2)
