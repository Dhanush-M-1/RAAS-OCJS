victim_1, victim_2 = input().split()
n = int(input())
print("%s %s" % (victim_1, victim_2))
for i in range(n):
    a, b = input().split()
    if(victim_1 == a):
        victim_1 = b
    else:
        victim_2 = b
    print("%s %s" % (victim_1, victim_2))