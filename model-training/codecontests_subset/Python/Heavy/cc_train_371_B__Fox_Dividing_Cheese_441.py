import sys
input = sys.stdin.readline
def multi_input():
    return map(int, input().split())

def array_print(arr):
    print(' '.join(map(str, arr)))

def solve2(x):
    flag=0
    prev = 0
    arr = [0,0,0]
    while flag==0:
        if x%2==0:
            x = x//2
            arr[0] +=1
        if x%3==0:
            x = x//3
            arr[1] += 1
        if x%5==0:
            x = x//5
            arr[2] += 1
        if x==prev:
            flag=1
        prev = x
    return x, arr

x,y = multi_input()

if x==y:
    print(0)
else:
    x1, arr1 = solve2(x)
    y1, arr2 = solve2(y)
    result = 0
    if x1==y1:
        # print(arr1,arr2)
        for i in range(3):
            result += abs(arr1[i]-arr2[i])
        print(result)
    elif result==0:
        print(-1)
