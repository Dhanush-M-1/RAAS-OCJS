def main():
    nm = input()
    nm = nm.split(" ")
    n = int(nm[0])
    m = int(nm[1])
    bulbs = [False]*m
    for i in range(n):
        b = input()
        b = b.split(" ")
        for j in range(1,len(b)):
            bulbs[int(b[j])-1]=True
    printed = False
    for k in range(m):
        if (bulbs[k]==False):
            print("NO")
            printed = True
            break
    if not printed:
        print("YES")
main()