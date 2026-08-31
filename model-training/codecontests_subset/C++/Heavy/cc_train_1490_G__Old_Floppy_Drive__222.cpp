#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define M 1000000007

int main()
{
    int t; scanf("%d",&t);
    while(t--)
    {
        int n,m; scanf("%d %d",&n,&m);
        ll a[n]; for(int i=0;i<n;i++) scanf("%lld",&a[i]);
        int b[m]; for(int i=0;i<m;i++) scanf("%d",&b[i]);
        vector<ll>v;
        vector<int>v1;
        ll sum=a[0]; v.push_back(a[0]); v1.push_back(1);
        ll prev=a[0]; ll y=a[0];
        for(int i=1;i<n;i++){
            sum+=a[i];
            if(i==n-1) y=sum;
            if(sum>prev){
                v.push_back(sum);
                v1.push_back(i+1);
                prev=sum;
            }
        }
        ll maxx=v[v.size()-1];
        for(int i=0;i<m;i++)
        {
            if(b[i]<=maxx)
            {
                int c=lower_bound(v.begin(),v.end(),b[i])-v.begin();
                printf("%d ",v1[c]-1);
            }
            else if(y>0){
                int x=b[i]-((b[i]-maxx+y-1)/y)*y;
                int c=lower_bound(v.begin(),v.end(),x)-v.begin();
                ll ans=((b[i]-maxx+y-1)/y)*n+v1[c]-1;
                printf("%lld ",ans);
            }
            else printf("-1 ");
        }
        printf("\n");
    }
}
