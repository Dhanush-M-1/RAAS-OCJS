




import sys


if __name__=="__main__":
    for _ in range(int(input())):
        n = int(input())
        arr = list(map(int,input().split()))
        curr = arr[0]
        max_diff = -1
        l = sys.maxsize
        r = -1
        for i in range(1,n):
            if(arr[i]!=-1 and arr[i-1]!=-1):
                max_diff = max(max_diff, abs(arr[i]-arr[i-1]))
        
        for i in range(1,n):
            if(arr[i]==-1):
                if(arr[i-1]!=-1):
                    if (arr[i-1]<=l):
                        l = arr[i-1]
                    if(arr[i-1]>r):
                        r = arr[i-1]
            else:
                if(arr[i-1]==-1):
                    if (arr[i]<=l):
                        l = arr[i]
                    if(arr[i]>r): 
                        r = arr[i]
                        
        if(r==-1 and l==sys.maxsize):
            k = 0
            fin_diff = max(max_diff,0)
        elif(r==-1 or r==l):
            k = l
            fin_diff = max(max_diff, abs(k-l))
        elif(l==sys.maxsize):
            k = r
            fin_diff = max(max_diff, abs(k-r))
        else:
            k = l + (r-l)//2
            fin_diff = max(max_diff, max(abs(k-l),abs(k-r)))
        print (str(fin_diff) + " " + str(k))