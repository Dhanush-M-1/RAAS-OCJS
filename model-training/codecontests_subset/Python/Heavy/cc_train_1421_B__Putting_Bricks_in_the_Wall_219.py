from functools import reduce
import collections
import math
import sys

class Read:
    @staticmethod
    def string():
        return input()
 
    @staticmethod
    def int():
        return int(input())
 
    @staticmethod
    def list(delimiter=' '):
        return input().split(delimiter)
 
    @staticmethod
    def list_int(delimiter=' '):
        return list(map(int, input().split(delimiter)))


# infilename = 'input.txt'
# sys.stdin = open(infilename, 'r')
# outfilename = 'output.txt'
# sys.stdout = open(outfilename, 'w')

def main():
    t = Read.int()
    for _ in range(t):
        n = Read.int()
        a = list()
        for i in range(n):
            a.append(list(Read.string()))
        
        if (a[0][1] == a[1][0] and a[1][0] == a[n-1][n-1-1] and a[n-1][n-1-1] == a[n-1-1][n-1]):
            print("2", "1 2", "2 1", sep= '\n')
        elif (a[0][1] == a[1][0] and a[1][0] != a[n-1][n-1-1] and a[n-1][n-1-1] == a[n-1-1][n-1]):
            print(0)
        else:
            kk = {'1': [], '0': []}
            if a[0][1] == '1':
                kk['1'].append("2 1")
            else:
                kk['0'].append("2 1")

            if a[1][0] == '1':
                kk['1'].append("1 2")
            else:
                kk['0'].append("1 2")

            if a[n-1][n-1-1] == '1':
                kk['1'].append(str(n-1)+" "+str(n))
            else:
                kk['0'].append(str(n-1)+" "+str(n))

            if a[n-1-1][n-1] == '1':
                kk['1'].append(str(n)+" "+str(n-1))
            else:
                kk['0'].append(str(n)+" "+str(n-1))

            # print(kk)
            if (len(kk['1']) == len(kk['0'])):
                print(2)
                print("2 1")
                if (a[0][1] != a[n-1][n-1-1]):
                    print(str(n-1)+" "+str(n))
                else:
                    print(str(n)+" "+str(n-1))
                    

            else:
                print(1)
                if (len(kk['1']) < len(kk['0'])):
                    print(kk['1'][0])
                else:
                    print(kk['0'][0])

if __name__ == '__main__':
    main()
