# import sys

# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')

t = 1
t = int(input())

while t:
    t -= 1

    n = int(input())
    a = list(map(int, input().split()))
    # s = input()
    if a[0] + a[1] > a[-1]:
        print(-1)
    else:
        print(1,2,n)


    


