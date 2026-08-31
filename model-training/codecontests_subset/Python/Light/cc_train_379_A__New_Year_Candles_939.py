burning, eff = map(int, input().split())

times = 0
extra = 0
while burning > 0:
    times += burning
    tmp = burning+extra
    extra = (tmp) % eff
    burning = (tmp-extra) // eff

print(times)
