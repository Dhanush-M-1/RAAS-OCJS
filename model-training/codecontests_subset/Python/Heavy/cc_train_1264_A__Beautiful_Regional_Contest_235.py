t=int(input())
for _ in range(t):
    n=int(input())
    s=[int(x) for x in input().split()]
    ps=s[len(s)//2:]
    s=s[:len(s)//2]
    if(len(s)==0):
        print(0,0,0)
    else:
        L=[]
        uni=[]
        c=1
        for i in range(1,len(s)):
            if(s[i]!=s[i-1]):
                L.append((s[i-1],c))
                uni.append(s[i-1])
                c=1
            else:
                c+=1
        L.append((s[-1],c))
        uni.append(s[-1])


        if(uni[-1]==ps[0]):
            uni=uni[:len(uni)-1]
            L=L[:len(L)-1]

        if(len(L)==0):
            print(0,0,0)
        else:

            ct=[y for (x,y) in L]

            pre=[ct[0]]

            for i in range(1,len(ct)):
                pre.append(pre[-1]+ct[i])

            #print('L',L)
            #print('uni',uni)
            #print('pre',pre)
            #print('ct',ct)

            gi=-1
            sl=-1

            for i in range(0,len(ct)):
                c1=pre[i]

                trg=(2*c1)+1

                #print('i',i,trg)

                low=i+1
                high=len(pre)-1

                temp1=-1

                while(low<=high):
                    mid=(low+high)>>1

                    if(pre[mid]>=trg):
                        temp1=mid
                        high=mid-1
                    else:
                        low=mid+1



                if(temp1!=-1):

                    

                    low=temp1+1
                    high=len(pre)-1

                    trg=pre[temp1]+pre[i]+1

                    temp2=-1

                    while(low<=high):
                        mid=(low+high)>>1

                        if(pre[mid]>=trg):
                            temp2=mid
                            high=mid-1
                        else:
                            low=mid+1

                   
                    if(temp2!=-1):

                        sl=pre[temp1]-pre[i]

                        gi=max(gi,i)

                    else:
                        break

                else:
                    break


            if(gi==-1):
                print(0,0,0)

            else:

                g=pre[gi]
                br=pre[-1]-sl-g

                print(g,sl,br)

                

                    
                

            


        
