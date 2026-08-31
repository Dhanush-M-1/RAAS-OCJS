import sys
def read(): return [int(i) for i in sys.stdin.readline().strip().split()]

for i in range(int(input())):
    n,m = read()
    a = read()
    b = read()
    if m < n:
        for j in range(m):
            if(b[j] in a):
                print("YES")
                print(1,b[j])
                break;
        else:
            print("NO")
    else:
        for j in range(n):
            if(a[j] in b):
                print("YES")
                print(1,a[j])
                break;
        else:
            print("NO")