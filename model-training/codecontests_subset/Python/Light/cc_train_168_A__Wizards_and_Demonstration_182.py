import math
n_x_y = list(map(int,input().split()))
minn = math.ceil((n_x_y[2] / 100) * n_x_y[0])
req = minn - n_x_y[1]
if req < 0 :
    print('0')
else:
    print(req)
