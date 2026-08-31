# All the power is within you. You can do anything. Swami Vivekananda
# by : Blue Edge - Create some chaos

for _ in range(int(input())):
    n=int(input())
    res=True
    px=0
    cx=0
    while n:
        n-=1
        p,c=map(int,input().split())
        if not res:
            continue
        if p<px:
            res=False
            continue
        if c<cx:
            res=False
            continue

        if p-px<c-cx:
            res=False
            continue
        px=p
        cx=c

    print("YNEOS"[not res::2])
    # print()
