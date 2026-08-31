def solve(n):
    if n == 1:
        return 0
    if n == 2:
        return -1
    if n == 3:
        return 2
    k = 1
    k = n
    two = 0
    three = 0
    while k%2 == 0:
        k //=2
        two += 1
    k = n
    while k%3 == 0:
        k //=3
        three += 1    
    if two > three:
        return -1
    n = n/ pow(2, two)
    n = n/pow(3, three)
    if n!=1:
        return -1
    return three *2 - two
t = int(input())
for we in range(t):
    n = int(input())
    print(solve(n))


        