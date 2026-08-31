
##########################################################
from collections import Counter
# c=sorted((i,int(val))for i,val in enumerate(input().split()))
import heapq
# c=sorted((i,int(val))for i,val in enumerate(input().split()))
# n = int(input())
# ls = list(map(int, input().split()))
# n, k = map(int, input().split())
# n =int(input())
# e=list(map(int, input().split()))
from collections import Counter
#print("\n".join(ls))
#print(os.path.commonprefix(ls[0:2]))
#for _ in range(int(input())):
for _ in range(int(input())):

    n=int(input())


    arr = list(map(int, input().split()))

    if arr[0]+arr[1]<=arr[-1]:
        print(1, 2, n)
    else:
        print(-1)





















