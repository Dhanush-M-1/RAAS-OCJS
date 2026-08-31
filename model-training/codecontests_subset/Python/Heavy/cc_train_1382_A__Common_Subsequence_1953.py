a = int(input())
i = 0
while i < a :
    b = input().split(" ")
    c = input().split(" ")
    d = input().split(" ")
    def common_elements(c, d):
        c.sort()
        d.sort()
        i, j = 0, 0
        common = []
        while i < len(c) and j < len(d):
            if c[i] == d[j]:
                common.append(c[i])
                break
                i += 1
                j += 1
            elif c[i] < d[j]:
                i += 1
            else:
                j += 1
        return common
    if (common_elements(c , d)) == [] :
        print("NO")
    else:
        print("YES")
        print(1 , ', '.join(map(str, common_elements(c , d))))
    i = i + 1