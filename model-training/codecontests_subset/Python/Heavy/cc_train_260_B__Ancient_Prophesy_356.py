days=dict()
for year in range(2013,2016):
    for month in range(1,13):
        if month in [1,3,5,7,8,10,12]:
            for day in range(1,32):
                if(day<10):
                    if(month<10):days['0'+str(day)+'-'+'0'+str(month)+'-'+str(year)]=0;
                    else:days['0'+str(day)+'-'+str(month)+'-'+str(year)]=0;
                elif(month<10):days[str(day)+'-'+'0'+str(month)+'-'+str(year)]=0;
                else:days[str(day)+'-'+str(month)+'-'+str(year)]=0;
        elif month in [4,6,9,11]:
            for day in range(1,31):
                if(day<10):
                    if(month<10):days['0'+str(day)+'-'+'0'+str(month)+'-'+str(year)]=0;
                    else:days['0'+str(day)+'-'+str(month)+'-'+str(year)]=0;
                elif(month<10):days[str(day)+'-'+'0'+str(month)+'-'+str(year)]=0;
                else:days[str(day)+'-'+str(month)+'-'+str(year)]=0;
        elif month in [2]:
            for day in range(1,29):
                if(day<10):
                    if(month<10):days['0'+str(day)+'-'+'0'+str(month)+'-'+str(year)]=0;
                    else:days['0'+str(day)+'-'+str(month)+'-'+str(year)]=0;
                elif(month<10):days[str(day)+'-'+'0'+str(month)+'-'+str(year)]=0;
                else:days[str(day)+'-'+str(month)+'-'+str(year)]=0;
st=input()
for i in days:
    days[i]=st.count(i)
print(max(days, key=days.get))