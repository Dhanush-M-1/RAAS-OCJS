# Om Namh Shivai
# Jai Shree Ram
# Radhe Krishna
# Jai BajrangBali
# Jai Maa Durga
# Jai Maa Kali

for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    sa= arr
    status = 0
    result = list()
    c = arr[len(arr)-1]
    b = arr[0]
    a = arr[1]
    if(a+b <= c):
        index1 = arr.index(a)+1
        index2 = arr.index(b)+1
        index3 = arr.index(c)+1
        print(1,2,len(arr))
    else:
        print(-1)