import sys
import math

read = sys.stdin.buffer.read
input = sys.stdin.buffer.readline
readlines = sys.stdin.buffer.readlines
t = int(input())
for case in range(t):
    n = int(input())
    r = 0.5000 / math.sin(math.radians(180 / (2 * n)))
    # print(1 / math.tan(math.radians(180 / (2 * n))))
    min_theta = 45  # 45からの角度最小を求める
    for i in range(1, n):
        tmp_i = min(abs((180 * i) / n - 45), abs((180 * i) / n - 135))
        min_theta = min(min_theta, tmp_i)
    # print(r, min_theta)
    print(2 * r * math.cos(math.radians(min_theta)))
