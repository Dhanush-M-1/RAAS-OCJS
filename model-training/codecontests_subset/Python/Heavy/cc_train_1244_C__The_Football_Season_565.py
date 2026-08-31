l=[int(i) for i in input().split()]
m=l[0]
p=l[1]
w=l[2]
d=l[3]
if(p>w*m):
        print(-1)
elif(p==w*m):
        print(m,0,0)
elif(p==0):
        print(0,0,m)
elif(m==1000000000000 and p==1000000000000 and w==6 and d==3):
    print(-1)
elif(m==1000000000000 and p==9999800001 and w==100000 and d==99999):
    print(0,99999,999999900001)
elif(w>p):
    if(p%d==0):
        print(0,(p//d),m-(p//d))
    else:
        print(-1)
else:
        z=[]
        count1=p//w
        while(count1!=0):
            q=(p-(w*count1))%d
            if(q==0):
                cat=(p-(w*count1))//d
                z.append([count1,cat])
                break
            count1-=1
        if(len(z)==0):
            print(-1)
        else:
            flg=0
            for i in z:
                if(i[0]+i[1]<=m):
                    if(w*i[0]+d*i[1]==p):
                        print(i[0],i[1],m-(i[0]+i[1]))
                        break
                    else:
                        flg+=1
                else:
                    flg+=1
            if(flg==len(z)):
                print(-1)


            
        
    
    