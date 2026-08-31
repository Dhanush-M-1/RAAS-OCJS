def encode(a):
    hour = 0
    minu = 0
    sec = 0
    if a >= 3600:
        hour = int(a/3600)
        a = a%3600
    if a >= 60:
        minu = int(a/60)
        a = a%60
    sec = a
    return hour,minu,sec
    
def decode(hour,minu,sec):
    return 3600*hour + 60*minu + sec

while(1):
    t,h,s = [int(i) for i in input().split()]
    if t == -1 and h == -1 and s == -1:
        break
    secs = decode(t,h,s)
    left_secs = 120*60 - secs
    hour,minu,sec = encode(left_secs)
    hour_,minu_,sec_ = encode(3*left_secs)
    print("{:0>2}:{:0>2}:{:0>2}".format(hour,minu,sec))
    print("{:0>2}:{:0>2}:{:0>2}".format(hour_,minu_,sec_))
