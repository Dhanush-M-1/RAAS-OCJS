victim1, victim2 = input().split()
n = int(input())
print(victim1, victim2)
for i in range(n):
    scan1, scan2 = input().split()
    if scan1 == victim1:
        victim1 = scan2
    elif scan1 == victim2:
        victim2 = scan2
    print(victim1, victim2)
