#
# :author:   Polusummator
# :date:     02.09.2020
# :filename: B.py
# :team:     Little PyPy Squad
#
t = int(input())
for i in range(t):
    n = int(input())
    if n == 1:
        print(0)
    else:
        n1 = n
        one = 0
        while n1 >= 6:
            if n1 % 6 == 0:
                n1 //= 6
                one += 1
            else:
                break
        # one -= 1
        # print('6', one)
        n1 = n // (6 ** one)
        # print(n1)
        two = 0
        # one -= 1
        while n1 >= 3:
            if n1 % 3 == 0:
                n1 //= 3
                two += 1
            else:
                break
        # two -= one
        # print('3', two)
        # print(one, two)
        if (6 ** one) * (3 ** two) == n:
            print(one + two * 2)
        else:
            print(-1)
