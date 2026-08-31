n=int(input())
def cur(x):
    if len(x)==n:
        s="".join([chr( ord("a")+x[i]) for i in range(n)])
        print(s)

    else:
         for i in range(max(x)+2):
             cur(x+[i])

cur([0])