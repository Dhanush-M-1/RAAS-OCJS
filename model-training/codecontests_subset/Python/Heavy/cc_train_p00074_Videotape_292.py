import datetime

while True:
    T,H,S = map(int,input().split())
    if T == -1 and H == -1 and S == -1:
        break

    s0 = 2 * 60**2
    s  = T * 60**2 + H * 60 *1 + S

    s1 = s0 - s
    s3 = 3 * s1

    T1 = s1//60**2
    H1 = (s1-T1*60**2)//60
    S1 = s1 - T1*60**2 - H1*60*1

    if H1 < 10 and S1 < 10:
        print("0%d:0%d:0%d" %(T1,H1,S1))

    elif H1 <10 and S1 >=10:
        print("0%d:0%d:%d" %(T1,H1,S1))

    elif S1 <10:
        print("0%d:%d:0%d" %(T1,H1,S1))
    else:
        print("0%d:%d:%d" %(T1,H1,S1))


    T3  = s3//60**2
    H3 = (s3-T3*60**2)//60
    S3 = s3 - T3*60**2 - H3*60*1

    if H3 < 10 and S3 < 10:
        print("0%d:0%d:0%d" %(T3,H3,S3))

    elif H3 <10 and S3 >=10:
        print("0%d:0%d:%d" %(T3,H3,S3))

    elif S3 <10:
        print("0%d:%d:0%d" %(T3,H3,S3))
    else:
        print("0%d:%d:%d" %(T3,H3,S3))

