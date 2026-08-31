#include <iostream>
#include <stdio.h>
using namespace std;
int main()
{
    long long t,n,sum[10],total[200001],temp,temp1,temp2,inf=1000000007,j,ans,formulation;
    long long i,m,xiao=200000;
    for(i=0; i<10; i++)
        sum[i]=0;
    sum[0]=1;
    sum[1]=1;
    total[0]=2;
    for(i=1; i<=xiao; i++)
    {
        temp=sum[8]%inf;
        sum[8]=sum[7]%inf;
        sum[7]=sum[6]%inf;
        sum[6]=sum[5]%inf;
        sum[5]=sum[4]%inf;
        sum[4]=sum[3]%inf;
        sum[3]=sum[2]%inf;
        sum[2]=sum[1]%inf;
        sum[1]=sum[0]%inf+sum[9]%inf;
        sum[0]=sum[9]%inf;
        sum[9]=temp;
        total[i]=(sum[0]+sum[1]+sum[2]+sum[3]+sum[4]+sum[5]+sum[6]+sum[7]+sum[8]+sum[9])%inf;
    }
    scanf("%lld",&t);
    for(j=0; j<t; j++)
    {
        ans=0;
        scanf("%lld%lld",&n,&m);
        while(n!=0)
        {
            formulation=m+n%10-10;
            if(formulation<0)
                ans=(ans+1)%inf;
            else
            {
                ans=(ans+total[formulation])%inf;
            }
            n=n/10;
        }
        printf("%d\n",ans%inf);
    }
    return 0;
}
