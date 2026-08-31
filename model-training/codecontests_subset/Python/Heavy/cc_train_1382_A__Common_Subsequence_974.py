def inArr(arr,i,n):
    if(i==n-1):
        return True
    if(arr[i] in arr):
        return inArr(arr,i+1)
    else: 
        return False
def main():
    t = int(input())
    for _ in range(t):
        n,m = list(map(int,input().split()))
        a = list(map(int,input().split()))
        b = list(map(int,input().split()))
        array =[]
        flag= True
        current = -1
        for e in a:
            if(e in b):
                flag=False
                current = e
                break
        if(flag):
            print("NO")
        else:
            print("YES")
            print(1,current)
main()