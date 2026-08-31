if __name__=="__main__":
    t = int(input())
    nums = []
    for i in range(t):
        nums.append(int(input()))
    
    output = []

    for n in nums:
        if n == 1:
            output.append(0)      
        elif n%3 != 0:
            output.append(-1)
        else:
            counter2 = 0
            counter3 = 0
            while(n%2 == 0):
                n = n//2
                counter2 += 1
            while(n%3 == 0):
                n = n//3
                counter3 += 1
            if(n != 1 or counter2 > counter3):
                output.append(-1)
            elif(counter3 >= counter2):
                output.append(counter3 + (counter3-counter2))
    for x in output:
        print(x)