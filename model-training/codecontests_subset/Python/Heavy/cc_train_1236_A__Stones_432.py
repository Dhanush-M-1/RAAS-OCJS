num = int(input())


for i in range(num):
    a, b, c = map(int,input().split())


    def sum1(a,b,c) :
        sum = 0
        while True :
            if a >= 1 and b >= 2 :
                a -= 1
                b -= 2
                sum += 3
            else :
                if b >= 1 and c >= 2:
                    b -= 1
                    c -= 2
                    sum += 3
                else :
                    break
        return sum

    def sum2(a,b,c) :
        sum = 0
        while True :
            if b >= 1 and c >= 2 :
                b -= 1
                c -= 2
                sum += 3
            else :
                if a >= 1 and b >= 2:
                    a -= 1
                    b -= 2
                    sum += 3
                else :
                    break
        return sum

    print(max(sum1(a,b,c),sum2(a,b,c)))