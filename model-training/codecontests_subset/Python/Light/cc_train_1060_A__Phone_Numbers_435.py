n = eval(input())
c=input()
i =0
for j in range(n):
    if c[j] == "8":
        i+=1
print(min(i,(int)(n//11)))
