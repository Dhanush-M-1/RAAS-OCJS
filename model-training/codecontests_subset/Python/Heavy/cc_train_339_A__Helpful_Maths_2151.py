# inp = [int(x) for x in input().split()]
# a = int(input())
#
# b = inp[0]
# c = inp[1]
# for num in range(b,c):
#     if num % a == 0 :
#         print(num, end=" ")

# def pypart(n):
#     for i in range(0, n):
#         for j in range(0, i + 1):
#             print("* ", end="")
#         print("\r")
# n = int(input())
# pypart(n)

a = str(input())
app = []
count = 0
for j in a:
    if count % 2 == 0 or j == 0:
        app.append(a[count])
    count +=1
    # print(j)
app.sort()
print(*app,sep = "+")


