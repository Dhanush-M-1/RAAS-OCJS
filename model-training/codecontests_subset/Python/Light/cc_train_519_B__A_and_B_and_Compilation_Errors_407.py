
if __name__ == "__main__":
    n = int(input())
    arr1 = list(map(int,input().split()))
    arr2 = list(map(int,input().split()))
    arr3 = list(map(int,input().split()))
    sum1=0
    sum2=0
    sum3=0

    for i in range(n):
        sum1+=arr1[i]
    for i in range(n-1):
        sum2+=arr2[i]
    for i in range(n-2):
        sum3+=arr3[i]

    num1=sum1-sum2
    num2=sum2-sum3

    print(num1)
    print(num2)
