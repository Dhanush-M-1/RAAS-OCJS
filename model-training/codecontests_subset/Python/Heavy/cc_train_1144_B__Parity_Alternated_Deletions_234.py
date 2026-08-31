

def main():
    n = int(input())
    v = input().split()
    a = []
    b = []
    countc = 0
    countn = 0
    for i in range(n):
        if int(v[i]) % 2 == 0:
            countc += 1
            a.append(int(v[i]))
        else:
            countn += 1
            b.append(int(v[i]))
    a.sort()
    b.sort()
    if abs(countc - countn) <= 1:
        ans = 0
    else:
        ans = 0
        if len(a) > len(b):
            for i in range(len(a) - (len(b) + 1)):
                ans += a[i]
        else:
            for i in range(len(b) - (len(a) + 1)):
                ans += b[i]

    print(ans)





if __name__ == "__main__":
    main()