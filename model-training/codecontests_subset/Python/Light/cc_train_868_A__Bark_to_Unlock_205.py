key=input()
sl=int(input())
word=list()
for i in range(sl):
    nhap=input()
    word.append(nhap)
dau=False
cuoi=False
for j,i in enumerate(word):
    if key==i:
        print("YES")
        exit()
    if i[0]==key[1]:
        cuoi=True
    if i[1]==key[0]:
        dau=True

if dau and cuoi:
    print("YES")
else:
    print("NO")

