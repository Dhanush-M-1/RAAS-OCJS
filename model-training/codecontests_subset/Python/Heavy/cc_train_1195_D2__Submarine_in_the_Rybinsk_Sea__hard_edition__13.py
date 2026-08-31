n = int(input())
a = input()
b = a.split(' ')
l = len(b[0])
z = ""
times = []
pre = []
for i in range(12):
    times.append(0)
    pre.append(0)
for i in range(n):
    times[len(b[i])] = times[len(b[i])] + 1
p = 998244353
pre[1] = times[1]
for i in range(2,12):
    pre[i] = pre[i - 1] + times[i]
su = 0
for i in range(n):
    #for the same size shit
    cur = b[i]
    siz = len(b[i])
    num = ""
    for j in range(siz):
        num = num + b[i][j]
        num = num + "0"
    num = int(num)
    #print("1 " + str(num))
    su = (su%p + (num%p * times[siz]%p)%p)%p
    num = num//10
    #print("2 " +str(num))
    su = (su%p + (num%p * times[siz]%p)%p)%p
 
    #for nums whose length is lesser than cur
    for j in range(1, siz):
        if (times[j] == 0):
            continue
        dif = siz - j
        cur_num1 = cur[0:dif]
        cur_num2 = cur[0:dif]
        for k in range(dif, siz):
            cur_num1 = cur_num1 + cur[k]
            cur_num1 = cur_num1 + "0"
            cur_num2 = cur_num2 + "0"
            cur_num2 = cur_num2 + cur[k]
        cur_num1 = int(cur_num1)
        cur_num2 = int(cur_num2)
        #print("3 " +str(cur_num))
        su = (su%p + (cur_num1%p * times[j]%p)%p)%p
        su = (su%p + (cur_num2%p * times[j]%p)%p)%p
 
    #for nums whose size if bigger than cur
    num = num * 10
    su = (su%p + (num%p * (pre[10] - pre[siz])%p)%p)%p
    num = num // 10
    su = (su%p + (num%p * (pre[10] - pre[siz])%p)%p)%p
    #print(su)
    
print(su)
 
 