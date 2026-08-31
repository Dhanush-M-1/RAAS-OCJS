import math
        
if __name__ =="__main__":
        temp = list(map(int , input().rstrip().split()))
        n = temp[0]
        x = temp[1]
        y = temp[2]
        
        totalRequired = math.ceil(n * y / 100)
        if x >= totalRequired:
                print(0)
        else:
                print(totalRequired - x)
