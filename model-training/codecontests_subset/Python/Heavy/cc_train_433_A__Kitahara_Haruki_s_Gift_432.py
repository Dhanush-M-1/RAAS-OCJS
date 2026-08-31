# import sys
# sys.setrecursionlimit(10**7)
# def input(): return sys.stdin.readline()[:-1]

#####################################################
###### COMMENT FIRST THREE LINS FOR CODEFORCES ######
#####################################################

mod = 10**9 + 7
def readInt():return int(input())
def readIntList():return list(map(int,input().split()))
def readStringList():return list(input())
def readStringListWithSpace():return list(input().split())
def readString():return input()
from heapq import heappop,heappush,heapify

def execute():
    n = readInt()
    arr = readIntList()
    a,b = 0,0
    for val in arr:
        if val == 200 :
            a += 1
        else:
            b += 1
    # print(a,b)
    print("YES") if (b != 0 and b%2 == 0) or (b == 0 and a%2 == 0) else print("NO")



if __name__ == "__main__":
    execute()

    
