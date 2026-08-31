import fractions

T = int(input())

for i in range(T):

    a,b,c,d = map(int,input().split())

    if a < b or d < b:
        print ("No")
        continue

    elif b-c < 2:
        print ("Yes")
        continue

    elif (((a-b) % fractions.gcd(b,d-b)) + b - fractions.gcd(b,d-b) > c and ((a-b) % fractions.gcd(b,d-b)) + b - fractions.gcd(b,d-b) < b):
        print ("No")

    else:
        print ("Yes")
