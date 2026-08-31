n = int(input())

arr = []

for i in range(n):
    h, o = [int(x) for x in input().split()]
    arr.append((h, o))

def count(forms, index = 0):
    result = 0
    if index < len(forms):
        h, o = forms[index]
        result = count(forms, index + 1)
        for i, f in enumerate(forms):
            if i != index and o == f[0]:
                result +=1

    return result

print(count(arr))














# same=0
# n=int(input())
# a=[0 for i in range(n)]
# b=[0 for i in range(n)]
# arr=[0]*101
# for i in range(n):
#     a[i],b[i]=map(int,input().split())
#     arr[b[i]]+=1
# for i in range(n):
#     same+=arr[a[i]]
# print(same)
#
#
