#include<bits/stdc++.h>
using namespace std;
typedef long long ll;



#define MAX 1000000007
#define vi vector<int>
#define vl vector<long long>
#define pi pair<int,int>
#define pl pair<long long,long long>
#define pb push_back
#define mi map<int,int>
#define ml map<long long,long long>

ll dp[10][200001];
ll a[10];
ll b[10];

void makedp()
{
    ll i,j,ii,sz=0;
    for(i=0;i<10;i++)
    {
        dp[i][0]=1;

    }
    for(i=0;i<10;i++)
    {
        sz=1;
        for(j=0;j<10;j++){a[j]=0;b[j]=0;}
        a[i]=1;
        for(j=1;j<=200000;j++)
        {
          for(ii=0;ii<10;ii++)
          {
           if(ii==9)
           {
               sz+=a[ii];b[0]+=a[ii];b[1]+=a[ii];a[ii]=0;

           }
           else
           {
               b[ii+1]+=a[ii];a[ii]=0;
           }
          }
          dp[i][j]=sz;
          for(ii=0;ii<10;ii++)
          {
              a[ii]=b[ii];
              a[ii]=a[ii]%MAX;
              b[ii]=0;
          }

        }
    }
   // for(i=0;i<=20;i++)
   // {
   //     cout<<dp[1][i]<<" ";
   // }
   // printf("\n");

}
int main()
{
    makedp();
    int t;scanf("%d",&t);
    while(t--)
    {
        int n,m;
        scanf("%d %d",&n,&m);
        ll s=0;
        while(n)
        {
          //cout<<dp[n%10][m]<<" ";
          s+=dp[n%10][m];
          s=s%MAX;
          n/=10;
        }
        printf("%lld\n",s%MAX);

    }
    return 0;
}
