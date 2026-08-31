#ol=OrderedList([5,5,5,3,6,7]) #O(n*log(n))
#ol.add(10) #O(log(n))
#5 in ol #O(log(n))
#ol.rangeCountByValue(5,6) #O(log(n)) returns number of items in range [leftVal,rightVal] inclusive
#ol.pop(1) #O(log(n)) removes at index 1
#ol.remove(5) #O(log(n)) removes item of value 5
#ol[3] #O(log(n)) retrieves item at index 3
#ol.bisect_left(8)
#ol.bisect_right(8)
# len(ol) #O(1)
# print(ol)

def main():
    
    t=int(input())
    allans=[]
    for _ in range(t):
        n=int(input())
        r=[1]+readIntArr()
        c=[1]+readIntArr()
        rc=list(zip(r,c))
        rc.sort(key=lambda x:x[0]) # sort by row asc
        ans=0
        # print(rc)##
        for i in range(len(rc)-1):
            ii1,jj1=rc[i]
            ii2,jj2=rc[i+1]
            if ii1==ii2:
                continue
            
            k=ii2-ii1
            if (ii1+jj1)%2==0:
                expectedjj2=jj1+k-1
            else:
                expectedjj2=jj1+k
            # print('ii1:{} jj1:{} ii2:{} jj2:{} expjj2:{}'.format(ii1,jj1,ii2,jj2,expectedjj2))
            if jj2>expectedjj2:
                assert expectedjj2+1==jj2
                ans+=(ii2-ii1)
            else:
                ans+=((1+expectedjj2-jj2)//2)
        allans.append(ans)
    multiLineArrayPrint(allans)
    
    return
    
import sys
input=sys.stdin.buffer.readline #FOR READING PURE INTEGER INPUTS (space separation ok)
# import sys
# input=lambda: sys.stdin.readline().rstrip("\r\n") #FOR READING STRING/TEXT INPUTS.




def oneLineArrayPrint(arr):
    print(' '.join([str(x) for x in arr]))
def multiLineArrayPrint(arr):
    print('\n'.join([str(x) for x in arr]))
def multiLineArrayOfArraysPrint(arr):
    print('\n'.join([' '.join([str(x) for x in y]) for y in arr]))
 
def readIntArr():
    return [int(x) for x in input().split()]
# def readFloatArr():
#     return [float(x) for x in input().split()]

def queryInteractive(x,y):
    print('? {} {}'.format(x,y))
    sys.stdout.flush()
    return int(input())

def answerInteractive(ans):
    print('! {}'.format(ans))
    sys.stdout.flush()
 
inf=float('inf')
MOD=10**9+7

for _aa in range(1):
    main()