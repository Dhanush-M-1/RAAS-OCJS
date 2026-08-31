a, b = map(int, input().split())
hour = a
rem = a
while rem >= b:
	hour += rem // b
	rem = rem // b + rem % b
print(hour)