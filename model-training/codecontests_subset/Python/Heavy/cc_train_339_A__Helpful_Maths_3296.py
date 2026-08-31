import sys
input = sys.stdin.readline

# Input Functions

# Take integer input
def inp():
    return(int(input()))
# Take list input
def inlt():
    return(list(map(int, input().split())))
# Take string as list of characters
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
# Take space separated integer variable inputs
def invr():
    return(map(int, input().split()))

s = input()
arr = []
for i in range(0, len(s), 2):
    arr.append(int(s[i]))
arr.sort()
ans = str(arr[0])

for i in range(1, len(arr)):
    ans += "+" + str(arr[i])

print(ans)
