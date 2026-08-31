def line(x1, y1, x2, y2):
    a1 = x2 - x1
    b1 = y2 - y1
    a1, b1 = b1, -a1
    c1 = -(a1 * x1 + b1 * y1)
    return [a1, b1, c1]


def check(x, y, x1, y1, x2, y2):
    if abs(((x - x1) ** 2 + (y - y1) ** 2) ** 0.5 + ((x - x2) ** 2 + (y - y2) ** 2) ** 0.5 - ((x1 - x2) ** 2 + (y1 - y2) ** 2) ** 0.5) < 0.1 ** 10:
        return True
    else:
        return False
    
    
n, x, y = map(int, input().split())
maxi = 0
pi = 3.1415926535897932384626433832795
s = []
for i in range(n):
    a, b = map(int, input().split())
    s.append([a, b])
    maxi = max((x - a) ** 2 + (y - b) ** 2, maxi)
mini = 10**20
for i in range(n):
    a2, b2, c2 = line(s[i][0], s[i][1], s[(i + 1) % n][0], s[(i + 1) % n][1])
    a1 = -b2
    b1 = a2
    c1 = -(x * a1 + b1 * y)
    xx, yy = (b1 * c2 - b2 * c1) / (-a2 * b1 + a1 * b2), (a1 * c2 - a2 * c1) / (a2 * b1 - a1 * b2)
    if check(xx, yy, s[i][0], s[i][1], s[(i + 1) % n][0], s[(i + 1) % n][1]):
        mini = min((a2 * x + b2 * y + c2) ** 2 / (a2 ** 2 + b2 ** 2), mini)
    else:
        mini = min((x - s[i][0]) ** 2 + (y - s[i][1]) ** 2, (x - s[(i + 1) % n][0]) ** 2 + (y - s[(i + 1) % n][1]) ** 2, mini)
print(pi * (maxi - mini))