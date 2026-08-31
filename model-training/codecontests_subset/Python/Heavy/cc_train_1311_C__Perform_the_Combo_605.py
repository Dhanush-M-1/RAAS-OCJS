"""
    Perform the Combo
"""
t = int(input())
for i in range(t):
    numberOfTimes = [0 for x in range(26)]
    n, m = [int(x) for x in input().split()]
    s = input()
    mPs = [int(x) for x in input().split()]
    mPs.append(len(s))
    mPs = sorted(mPs)
    m += 1
    minimum = 0
    for p in mPs:
        maximum = p
        for letter in s[minimum:maximum]:
            numberOfTimes[ord(letter)-97] += m
        minimum = maximum
        m -= 1

    for num in numberOfTimes:
        print(num, end=' ')
    print()