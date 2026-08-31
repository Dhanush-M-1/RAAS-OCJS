def main():    
    T = int(input().strip())
 
    for _ in range(T):
        n = int(input().strip())
        a = input().strip().split(" ")
        a = [int(x) for x in a]

        tmp = 0
        res1 = True
        for i, x in enumerate(a):
            if x < tmp:
                res1 = False
                break
            add = -1
            if i < n//2:
                add = 1
            elif i == n//2 and n % 2 == 0:
                add = -2
            tmp += add
        
        tmp = 0
        res2 = True
        for i, x in enumerate(a[::-1]):
            if x < tmp:
                res2 = False
                break
            add = -1
            if i < n//2:
                add = 1
            elif i == n//2 and n % 2 == 0:
                add = -2
            tmp += add
        
        if res1 or res2:
            print("Yes")
        else:
            print("No")

        


main()




