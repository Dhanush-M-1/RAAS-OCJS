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
# &	Bitwise AND Operator	10 & 7 = 2
# |	Bitwise OR Operator	10 | 7 = 15
# ^	Bitwise XOR Operator	10 ^ 7 = 13

# <<	Bitwise Left Shift operator	10<<2 = 40
# >>	Bitwise Right Shift Operator
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
    # tests =  inp()
    tests = 1
    # mod = 1000000007
    limit = 10**18
    ans = 0
    for test in range(tests):
        [n,k]  = inlt()
        b = []
        a = []
        both = []
        for i in range(n):
            [t,alice,bob] = inlt()
            if alice == 1 and bob == 1:
                both.append(t)
            elif alice == 1:
                a.append(t)
            elif bob == 1:
                b.append(t)
        both.sort()
        a.sort()
        b.sort()
        if len(both) + len(a) <k or len(both) + len(b) <k:
            print(-1)
            break
        # print(both,a,b)
        ans = 0
        a_i = 0
        b_i = 0
        both_i = 0
        for _ in range(k):
            if both_i != len(both) and a_i !=len(a) and b_i!= len(b):
                if both[both_i] < a[a_i] + b[b_i]:
                    ans = ans + both[both_i] 
                    both_i +=1
                    
                else:
                    ans = ans + a[a_i] + b[b_i]
                    a_i = a_i +1
                    b_i = b_i +1
                    
            elif both_i == len(both):
                ans = ans + a[a_i] + b[b_i]
                a_i = a_i +1
                b_i = b_i +1
                
            else:
                
                ans = ans + both[both_i] 
                both_i +=1
        print(ans)



 

            

            




if __name__== "__main__":
	main()