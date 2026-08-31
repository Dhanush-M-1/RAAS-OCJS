from math import *
def LCM(a,b):
    g = gcd(a,b)
    return (a * b)//g
    

def FadiLcm(num):
    maxs = num ** 0.5    
    for i in range(int(maxs),0,-1):
        if num % i == 0:
            div = i
            div2 = num//div
            if num // div == div:
                continue
            if LCM(div,div2) != num:
                continue
            break
    one = div
    two = num // div
    return str(one) + " " + str(two)


def main():    
    n = eval(input())
    print(FadiLcm(n))
            
main()
