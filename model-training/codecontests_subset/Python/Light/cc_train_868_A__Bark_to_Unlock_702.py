lock = input()
num = int(input())
lst = []
for i in range(num):
    lst.append(input())
#print("Output:")
#print(lock, num, lst, sep="\n")
a = False
b = False
for word in lst:
    if word==lock:
        a=True
        b=True
for word in lst:
    if word==lock:
        a=True
        b=True
    if word.endswith(lock[0]):
        a = True
        break
for word in lst:
    if word.startswith(lock[1]):
        b = True
        break
if a and b:
    print("YES")
else:
    print("NO")