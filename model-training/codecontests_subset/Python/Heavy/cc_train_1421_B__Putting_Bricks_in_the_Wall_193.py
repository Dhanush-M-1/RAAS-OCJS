def find(arr,N):
    R=[]
    if(arr[N-1][N-2]==arr[N-2][N-1]):
        a=arr[N-1][N-2]
        if(arr[1][0]==a): R.append((2,1))
        if(arr[0][1]==a): R.append((1,2))
    elif(arr[1][0]==arr[0][1]):
        a=arr[1][0]
        if(arr[N-1][N-2]==a): R.append((N,N-1))
        if(arr[N-2][N-1]==a): R.append((N-1,N))
    else:
        R.append((N,N-1))
        a=arr[N-1][N-2]
        if(arr[1][0]!=a): R.append((2,1))
        else: R.append((1,2))
    print(len(R))
    for x,y in R:
        print(x,y)



    


def main():
    for _ in range(int(input())):
        N=int(input())
        arr=[input().strip() for _ in range(N)]
        find(arr,N)
main()