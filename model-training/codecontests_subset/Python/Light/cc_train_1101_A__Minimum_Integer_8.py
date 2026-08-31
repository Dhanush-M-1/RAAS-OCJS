def func(l,r,d):
    if l<=d:
        print((r//d+1)*d)
    else:
        print(d)
            
def main():
    count=int(input())
    for _ in range(count):
        arr=input().split()
        func(int(arr[0]),int(arr[1]),int(arr[2]))
main()
