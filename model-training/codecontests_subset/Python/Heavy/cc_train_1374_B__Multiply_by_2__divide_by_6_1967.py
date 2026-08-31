#https://codeforces.com/contest/1374/problem/B
# submit dite pari nai.. time ses.. pore submit dibo!

t = int(input())
while t:
    n= int(input())
    flag = True
    count = 0
    if n == 1:
        count = 0
    else:
        while flag:
            if n==1 :
                flag = False
            elif n % 6 == 0:
                n = n / 6
                count += 1
            elif n % 3 == 0:
                n = n * 2
                n = n / 6
                count += 2
            else:
                flag = False
                count = -1

    print(count)
    count = 0
    t -= 1

"""
i/p

7
1
2
3
12
12345
15116544
387420489
"""

"""
o/p

0
-1
2
-1
-1
12
36
"""