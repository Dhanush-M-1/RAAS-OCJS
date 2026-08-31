n=int(input())
m=input()
hasil=""
banyakAngka=0
for i in range(len(m)):
    if(m[i] == '8'):
        banyakAngka += 1

harusnya = n//11

if(banyakAngka >= harusnya):
    print(harusnya)
else:
    print(banyakAngka)

