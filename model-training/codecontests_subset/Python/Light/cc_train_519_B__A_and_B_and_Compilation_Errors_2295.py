# cook your dish here
n = int(input())
e = [sum(map(int,input().split())) for _ in range(3)]
print(e[0]-e[1])
print(e[1]-e[2])