import sys
#sys.stdin = open('input.txt', 'r') 
#sys.stdout = open('output.txt', 'w')

import math

def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        # x, y, n = list(map(int, input().split()))       
        six = 0
        three = 0
        a = n
        while True:
            if(a%6==0):
                a = a//6
                six += 1
            else:
                break
        while True:
            if(a%3==0):
                a = a//3
                three += 1
            else:
                break
        if(a == 1):
            print(six + 2* three)
        else:
            print(-1)            

main()