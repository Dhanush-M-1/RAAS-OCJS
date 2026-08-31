class RFYP:

    def main(self):

        n = int(input())
        prize = [int(x) for x in input().split()]
        count1 = 0
        count2 = 0
        temp = 1

        for i in range(n):
            if(prize[i] - 1 < 1000000 - prize[i]):
                count1 = count1 + prize[i] - temp
            else:
                count2 = 1000000 - prize[i]
                break
            temp = prize[i]

        if(count1 > count2):
            print(count1)
        else:
            print(count2)

r = RFYP()
r.main()