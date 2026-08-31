#include <bits/stdc++.h>
#include <deque>
using namespace std;
#define ll long long int
#define tab " "
#define endl "\n"
ll m = 1000000007;
bool iseven(ll n)
{
    return n%2==0;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    ll t;
    cin>>t;
    
    while(t--)
    {
        ll k,m,n;
        cin>>k>>n>>m;
        ll a[n],b[m],ans[m+n];
        for (int i = 0; i < n; ++i)
        {
            cin>>a[i];

        }
        for (int i = 0; i < m; ++i)
        {
            cin>>b[i];
            
        }
        ll flag=0,i=0,j=0,it=0,l=0;
        while(l<m+n)
        {
            if (a[i]==0&&i<n)
            {
                ans[l++]=a[i++];
             
                k++;
                flag=0;
            }
            else if (b[j]==0&&j<m)
            {
                ans[l++]=b[j++];

                k++;
                flag=0;
            }
            else if (a[i]<=k&&a[i]>0&&i<n)
            {
                ans[l++]=a[i++];
                flag=0;



            }
             else if (b[j]<=k&&b[j]>0&&j<m)
            {
                ans[l++]=b[j++];
               
               flag=0;
                

            }
            else if (flag==1)
            {
                break;
                
            }
            else
            {
                flag=1;
            }
        
        }
        if (l<m+n)
        {
            cout<<-1<<endl;
        }
        else
        {
            for (int i = 0; i < m+n; ++i)
            {
                cout<<ans[i]<<tab;
            }
            cout<<endl;
        }



        
    }
}

