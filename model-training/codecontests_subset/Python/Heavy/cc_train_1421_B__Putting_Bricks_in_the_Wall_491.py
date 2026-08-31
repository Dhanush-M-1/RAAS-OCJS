import sys
import math
from collections import defaultdict,deque

input = sys.stdin.readline
def inar():
    return [int(el) for el in input().split()]
def main():
    t=int(input())
    for _ in range(t):
        n=int(input())
        matrix=[]
        for i in range(n):
            matrix.append(input().strip())
        count1=0
        ans1=[]
        if matrix[1][0]!='1':
            count1+=1
            ans1.append([2,1])
        if matrix[0][1]!='1':
            count1+=1
            ans1.append([1,2])
        if matrix[n-1][n-2]!='0':
            count1+=1
            ans1.append([n, n-1])
        if matrix[n-2][n-1]!='0':
            count1+=1
            ans1.append([n-1, n])
        count2=0
        ans2=[]
        if matrix[1][0]!='0':
            count2+=1
            ans2.append([2,1])
        if matrix[0][1]!='0':
            count2+=1
            ans2.append([1,2])
        if matrix[n-1][n-2]!='1':
            count2+=1
            ans2.append([n, n-1])
        if matrix[n-2][n-1]!='1':
            count2+=1
            ans2.append([n-1, n])
        if count1<count2:
            print(len(ans1))
            for i in range(len(ans1)):
                print(*ans1[i])
        else:
            print(len(ans2))
            for i in range(len(ans2)):
                print(*ans2[i])






if __name__ == '__main__':
    main()



