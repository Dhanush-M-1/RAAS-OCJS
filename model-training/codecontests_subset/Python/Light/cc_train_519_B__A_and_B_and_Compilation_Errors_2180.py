n = int(input())
s1 = sorted(input().split())
s2 = sorted(input().split())
s3 = sorted(input().split())
i = 0
while i < n:
    if i < n-1:
        if s1[i] != s2[i]:
            print(s1[i])
            i = n
    else:
        print(s1[i])
        i = n
    i = i + 1
i = 0
while i < n-1:
    if i < n-2:
        if s2[i] != s3[i]:
            print(s2[i])
            i = n
    else:
        print(s2[i])
        i = n
    i = i + 1



