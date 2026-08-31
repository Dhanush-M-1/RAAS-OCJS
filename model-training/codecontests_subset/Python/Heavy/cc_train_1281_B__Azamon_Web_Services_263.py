nn = int(input())

for _ in range(nn):
    s1, s2 = input().split()
    l1 = list(s1)
    n = len(s1)
    s3 = ""
    if s1 < s2:
        print(s1)
    else:
        d = {'A': True}
        for i in range(n):
            if s1[i] in d:
                continue
            else:
                to_swap = i
                for j in range(n - 1, i, -1):
                    if s1[j] < s1[to_swap]:
                        to_swap = j
                    if s1[j] == 'A':
                        break
                if to_swap != i:
                    l1[to_swap], l1[i] = l1[i], l1[to_swap]
                    s3 = "".join(l1)
                    break
                d[s1[i]] = True
        if s3 != "" and s3 < s2:
            print(s3)
        else:
            print('---')