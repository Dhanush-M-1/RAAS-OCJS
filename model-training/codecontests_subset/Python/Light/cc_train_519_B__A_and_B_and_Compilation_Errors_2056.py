n = int(input())
a1 = list(map(int, input().split()))
a2 = list(map(int, input().split()))
a3 = list(map(int, input().split()))
a1.sort()
a2.sort()
a3.sort()

def Compare(a, b):
    i = 0
    while i < len(b):
        if a[i] != b[i]:
            break
        i += 1
    return a[i]

print(Compare(a1, a2))
print(Compare(a2, a3))
