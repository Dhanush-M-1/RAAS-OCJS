if __name__ == "__main__":
        n = int(input().rstrip())
        apples = list(map(int , input().rstrip().split()))
    
        count2 = 0
        count1 = 0
        for i in apples:
                if i == 200:
                        count2 += 1
                else:
                        count1 += 1

        if count2 % 2 == 0:
                if count1 % 2 == 0:
                        print ("YES")
                else:
                        print ("NO")
        else:
                if count1 >= 2:
                        count1 = count1 - 2
                        if count1 % 2 == 0:
                                print ("YES")
                        else:
                                print ("NO")
                else:
                        print ("NO")
