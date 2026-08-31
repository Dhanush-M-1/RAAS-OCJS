p=input()
n=int(input())
w=[]
c=0
for i in range(n):
    w.append(input())
for i in w:
    for j in w:
        if p in i+j:
            print("YES")
            exit()
print("NO")

    