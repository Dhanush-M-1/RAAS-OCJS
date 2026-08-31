from collections import defaultdict as dfd
import math
import sys
import heapq
def II(): return int(sys.stdin.readline())
def MI(): return map(int, sys.stdin.readline().split())
def LI(): return list(map(int, sys.stdin.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def main():
    for _ in range(int(input())):
        N = II()
        co = 0
        while(N!=1):
            if(N%6==0):
                N/=6
                co+=1
            else:
                if(N%3==0):
                    N*=2
                    co+=1
                else:
                    break
        if(N==1):
            print(co)
        else:
            print(-1)

            



        

            

                

            
                
        
        

                
                
            
                















main()