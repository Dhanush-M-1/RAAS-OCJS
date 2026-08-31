import datetime
def check(ar):
    for i in range(len(ar)-2):
        s=ar[i]+ar[i+1]
        j=len(ar)-1
        if(s<=ar[j]):
            li=i+1,i+2,j+1
            return list(li) 
        else:
            return [-1]


if __name__=="__main__":
    
    n=int(input())
    res=[]
    for _ in range(n):
        q=int(input())
        arr=list(map(int,input().split()))
        res.append(arr)
    for items in res:
        result=check(items)
        print(*result)
    exit()
