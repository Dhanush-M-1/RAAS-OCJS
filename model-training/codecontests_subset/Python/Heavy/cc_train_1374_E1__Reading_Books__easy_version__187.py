n,k = map(int,input().split())
r = k
l = []
for _ in range(n):
    l.append(list(map(int,input().split())))
l1,l2,l3 = [],[],[]
for i in l:
    if i[1] == 1 and i[2] == 1:
        l1.append(i)
    elif i[1] == 1:
        l2.append(i)
    elif i[2] == 1:
        l3.append(i)
l1.sort(key = lambda x:x[0])
l2.sort(key = lambda x:x[0])
l3.sort(key = lambda x:x[0])
n1,n2,n3 = len(l1),len(l2),len(l3)
i,j,k = 0,0,0
a,b,s = 0,0,0
ans = 0

while a < r or b < r:

    if a < r and b < r:

        if i < n1 and (j<n2 and k<n3):
            if s+l1[i][0] < s+l2[j][0]+l3[k][0]:

                s+=l1[i][0];i+=1;a+=1;b+=1
            else:

                s += l2[j][0] + l3[k][0];j+=1;k+=1;a+=1;b+=1
        elif i>=n1 and (j<n2 and k<n3):

            s += l2[j][0] + l3[k][0];j += 1;k += 1;a += 1;b += 1
        elif i < n1 and ( j>=n2 or k>=n3):

            s+=l1[i][0];i+=1;a+=1;b+=1
        else:

            ans = -1
            break
    elif a < r:
        if i<n1 and j<n2:
            if s+l1[i][0] < s+l2[j][0]:
                s+=l1[i][0];i+=1;a+=1;
            else:
                s+=l2[j][0];j+=1;a+=1;
        elif i>n1 and j<n2:
            s+=l2[j][0];j+=1;a+=1;
        elif j>n2 and i<n1:
            s+l1[i][0];i+=1;a+=1
        else:
            ans = -1
            break
    else:
        if i<n1 and k<n3:
            if s+l1[i][0] < s+l[k][0]:
                s+=l1[i][0];i+=1;b+=1;
            else:
                s+=l3[k][0];k+=1;b+=1;
        elif i>n1 and k<n3:
            s+=l3[k][0];k+=1;b+=1;
        elif k>n3 and i<n1:
            s+l1[i][0];i+=1;b+=1
        else:
            ans = -1
            break
print(s if a == r and b == r else -1)

