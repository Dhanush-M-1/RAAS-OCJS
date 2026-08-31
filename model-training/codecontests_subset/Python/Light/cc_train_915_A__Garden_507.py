def main():
    n,k=map(int,input().split(" "))
    arr=[int(x) for x in input().split(" ")]
    arr.sort()
    temp=0
    for i in arr:
        if k%i==0:
            temp=i
        if i>k:
            break
    print(int(k/temp))

main()