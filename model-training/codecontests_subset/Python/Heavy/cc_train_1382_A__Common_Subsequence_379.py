######################################################
############Created by Devesh Kumar###################
#############devesh1102@gmail.com####################
##########For CodeForces(Devesh1102)#################
#####################2020#############################
######################################################
import sys
input = sys.stdin.readline
 
# import sys
import heapq 
import copy
import math
import decimal
 
# import sys.stdout.flush as flush
# from decimal import *
#heapq.heapify(li) 
#
#heapq.heappush(li,4) 
#
#heapq.heappop(li)
#
# &    Bitwise AND Operator    10 & 7 = 2
# |    Bitwise OR Operator    10 | 7 = 15
# ^    Bitwise XOR Operator    10 ^ 7 = 13
 
# <<    Bitwise Left Shift operator    10<<2 = 40
# >>    Bitwise Right Shift Operator
# '''############ ---- Input Functions ---- #######Start#####'''
 
 
def inp():
    return(int(input()))
def inlt(): 
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def insr2():
    s = input()
    return((s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))
############ ---- Input Functions ---- #######End
# #####   
 
 
 

def pr_list(a):
    print(*a, sep=" ")
def main():
    tests =  inp()
    # tests = 1
    mod = 1000000007
    limit = 10**18
    ans = 0
    stack = []
    hashm = {}
    arr = []
    heapq.heapify(arr) 

    for test in range(tests):
        [n,m] = inlt()
        a = inlt()
        b = inlt()
        hashm = {}
        for i in a:
            hashm[i] = 1
        ans = []

        for i in b:
            if i in hashm:
                ans = [1,i]
                break
        if ans == []:
            print("No")
        else:
            print("Yes")
            pr_list(ans)
    
        # if flag == 1:
        #     print("prob")
 
if __name__== "__main__":
    main()
    