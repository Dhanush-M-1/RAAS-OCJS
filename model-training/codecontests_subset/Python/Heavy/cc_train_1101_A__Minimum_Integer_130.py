def main():
    q = int(input())
    ans = []
    for i in range(q):
        inp = input().split()
        li = int(inp[0])
        r = int(inp[1])
        d = int(inp[2])

        ii = 1
        global s
        s = True

        if d < li:
            ans.append(d)
        elif d > r:
            ans.append(d)
        else:
            ans.append((int(r / d) + 1) * d)


        ##if d >= r:
         #   ans.append(2 * d)
        #elif d > li:
        #    ans.append((int(r / d) + 1) * d)
        #else:
        #    while d * ii < li:
        #        di = d * ii
        #        if di > r or di < li:
        #            ans.append(ii)
        #        ii += 1
        #    else:
        #        ans.append((int(r / d) + 1) * d)

    for i in range(q):
        print(ans[i])


main()
