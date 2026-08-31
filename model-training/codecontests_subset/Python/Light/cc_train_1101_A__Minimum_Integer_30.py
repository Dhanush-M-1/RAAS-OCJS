
n=int(input())

while n!=0:
    n=n-1
    str_len=input()
    l=int(str_len.split(' ')[0])
    r = int(str_len.split(' ')[1])
    d = int(str_len.split(' ')[2])
    # l=int(input())
    # r=int(input())
    # d=int(input())
    if d not in range(l,r+1):
        print(d)
    else:
        print(int(int((r/d+1))*d))