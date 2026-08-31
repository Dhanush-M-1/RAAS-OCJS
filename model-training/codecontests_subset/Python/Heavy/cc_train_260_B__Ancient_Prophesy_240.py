def main():
    s = input()
    l=[]
    a=["0","1","2","3","4","5","6","7","8","9"]
    for i in range(len(s)-9):
        if ((s[i] in a) or s[i]=="-") and (s[i+1] in a) and s[i+2]=="-" and (s[i+3] in a) and (s[i+4] in a) and s[i+5]=="-" and (s[i+6] in a) and (s[i+7] in a) and (s[i+8] in a) and (s[i+9] in a):
            l.append(s[i:i+10])
        elif ((s[i] in a) or s[i]=="-") and (s[i+1] in a) and s[i+2]=="-" and (s[i+3] in a) and s[i+4]=="-" and (s[i+5] in a) and (s[i+6] in a) and (s[i+7] in a) and (s[i+8] in a):
            l.append(s[i:i+9])
    i=0
    while(i<len(l)):
        if len(l[i])==10:
            date1 = l[i][0:2]
            month1 = l[i][3:5]
            year = l[i][6:10]
            date1 = list(date1)
            month1 = list(month1)
        else:
            date1 = l[i][0:2]
            month1=l[i][3:4]
            year = l[i][5:9]
            date1=list(date1)
            month1=list(month1)
        if date1[0]=="-":
            date1[0]="0"
        date=""
        month=""
        for i_ in date1:
            date+=i_
        for j_ in month1:
            month+=j_
        if len(month)==1:
            month="0"+month
        thirtyone =[1,3,5,7,8,10,12]
        twen=[2]
        #poss=[2013,2014,2015]
        #print(int(year))
        if int(year)>=2013 and int(year)<=2015:
            #print(int(year))
            if int(month) in thirtyone:
                if int(date)>0 and int(date)<=31:
                    i+=1
                    continue
                else:
                    l.remove(l[i])
            elif int(month) in twen:
                if int(date)>0 and int(date)<=28:
                    i+=1
                    continue
                else:
                    l.remove(l[i])
            else:
                if int(date)>0 and int(date)<=30:
                    i+=1
                    continue
                else:
                    l.remove(l[i])
        else:
            l.remove(l[i])
    #print(l)
    sett = set(l)
    m=0
    ans=0
    for i in sett:
       cnt = l.count(i)
       if cnt>m:
           ans=i
           m=cnt
    print(ans)
if __name__ == '__main__':
    main()
