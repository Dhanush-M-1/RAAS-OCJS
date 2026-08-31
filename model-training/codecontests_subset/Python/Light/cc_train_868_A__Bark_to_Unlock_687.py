pas=input()
n=int(input())
begin=False
end = False
same = False
for i in range(n):
    word = input()
    if word[0] == pas[1]:
        begin = True
    if word[1] == pas[0]:
        end = True
    if word == pas:
        same = True

if same:
    print("YES")
elif begin and end:
    print ("YES")
else:
    print("NO")
