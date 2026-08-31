q = int(input())
for asgafsdhheresfaddfg in range(q):
    a, b, c = map(int, input().split())
    ans1 = c
    ans2 = ((b + 1) // c) * c
    if (ans2 <= b):
        ans2 = (((b + 1)) // c + 1) * c

    if (ans1 < a):
        print(ans1)
    else:
        print(ans2)
