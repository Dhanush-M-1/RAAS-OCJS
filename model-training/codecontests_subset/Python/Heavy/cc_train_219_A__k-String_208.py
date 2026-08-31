# python3
import sys, threading, os.path
import collections, heapq, math,bisect
import string
from platform import python_version
import itertools
sys.setrecursionlimit(10**6)
threading.stack_size(2**27)

def main():
    if os.path.exists('input.txt'):
        input = open('input.txt', 'r')
    else:
        input = sys.stdin
    #--------------------------------INPUT---------------------------------
    n = int(input.readline())
    str1 = list(str(input.readline().rstrip('\n')))
    arr = [0]*27

    couldbe = True
    
    if len(str1)%n != 0:
        couldbe=False
    for x in str1:
        arr[ord(x)-96]+=1
    str1 = ""
    for i,x in enumerate(arr):
        if x%n != 0:
            couldbe=False
        if x >0:
            for j in range(int(x/n)):
                str1+=chr(i+96)
    if couldbe:
        res = ""
        for i in range(n):
            res+=str1
        output = res
    else:  
        output = -1
    #-------------------------------OUTPUT----------------------------------
    if os.path.exists('output.txt'):
        open('output.txt', 'w').writelines(str(output))
    else:
        sys.stdout.write(str(output))


if __name__ == '__main__':
    main()
#threading.Thread(target=main).start()