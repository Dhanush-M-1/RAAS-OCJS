import logging
import copy
import sys

logging.basicConfig(stream=sys.stderr, level=logging.DEBUG)

#def solve(firstLine):
def solve(n,m,lines):
    lst = [0] * m
    for g in lines:
        lst[g-1] += 1

    total = 0
    
    for i in range(m):
        for j in range(i+1,m):
            total += lst[i] * lst[j]
    
    return total

def main():
    firstLine = input().split()
    firstLine = list(map(int, firstLine))
    n,m = firstLine[0] ,firstLine[1]
    
    inputLines = input().split()
    inputLines = list(map(int, inputLines))
    
        
    #solve(firstLine)
    print(solve(n,m,inputLines))

def log(*message):
    logging.debug(message)
    
if __name__ == "__main__":
    main()
