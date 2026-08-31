import math
from collections import defaultdict

def primeFactors(num):
    lis = []
    while num % 2 == 0:
        lis.append(2)
        num = num // 2
    for i in range(3, int(math.sqrt(num)) + 1, 2):
        while num % i == 0:
            if i > 3:
                return []
            lis.append(i)
            num = num // i
    if num > 2:
        lis.append(num)
    return lis


t = int(input())
Dict = defaultdict(list)
for _ in range(t):
    n = int(input())
    if n == 1:
        print(0)
    else:
        if n % 3 != 0:
            print(-1)
        else:
            temp = Dict[n]
            if len(temp) == 0:
                x = primeFactors(n)
                Dict[n] = x
            else:
                x = temp
            if len(x) == 0:
                print(-1)
            else:
                x.sort()
                if x[-1] > 3:
                    print(-1)
                else:
                    two = x.count(2)
                    three = x.count(3)
                    if two > three:
                        print(-1)
                    else:
                        comm = two
                        rem = three - comm
                        print(comm+(rem*2))
