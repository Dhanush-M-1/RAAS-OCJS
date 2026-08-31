import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)


############ ---- Input Functions ---- ############
def in_int():
    return (int(input()))


def in_list():
    return (list(map(int, input().split())))


def in_str():
    s = input()
    return (list(s[:len(s) - 1]))


def in_ints():
    return (map(int, input().split()))

a, b  = in_ints()

count2 = 0
count3 = 0
count5 = 0

while a%2 == 0 :
    a = a//2
    count2 +=1

while a % 3 == 0:
    a = a // 3
    count3 += 1

while a % 5 == 0:
    a = a // 5
    count5 += 1


while b%2 == 0 :
    b = b//2
    count2 -=1

while b % 3 == 0:
    b = b // 3
    count3 -= 1

while b % 5 == 0:
    b = b // 5
    count5 -= 1

if b == a:
    ans  = abs(count2) + abs(count3) + abs(count5)
    print(ans)
else:
    print(-1)





