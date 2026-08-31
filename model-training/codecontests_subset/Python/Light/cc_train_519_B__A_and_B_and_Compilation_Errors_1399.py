input()
def d():
    return sum(map(int, input().split()))
r = d(), d(), d()
print(r[0]-r[1])
print(r[1]-r[2])
