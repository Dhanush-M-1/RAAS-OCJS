/*
**  Author: Kartikey Tewari
**  Time: 02-04-2021  17:40:25
*/

#include <bits/stdc++.h>
#define ll long long
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    ll tt;
    cin >> tt;
    for (ll yy=0;yy<=tt-1;yy++)
    {
        ll n,m;
        cin >> n >> m;
        vector<ll> arr(n);
        ll sum=0;
        for (ll i=0;i<=n-1;i++)
        {
            cin >> arr[i];
            sum+=arr[i];
        }

        vector<ll> query(m);
        for (ll i=0;i<=m-1;i++)
        {
            cin >> query[i];
        }

        vector<ll> pre_sum(n);
        ll val=0;
        ll pre_sum_max=0;
        for (ll i=0;i<=n-1;i++)
        {
            val+=arr[i];
            pre_sum[i]=val;
            pre_sum_max=max(pre_sum_max, pre_sum[i]);
        }

        vector<ll> pre_inc;
        vector<ll> pre_index;
        ll lead=pre_sum[0];
        pre_inc.push_back(lead);
        pre_index.push_back(0);
        for (ll i=0;i<=n-1;i++)
        {
            if (pre_sum[i]>lead)
            {
                lead=pre_sum[i];
                pre_inc.push_back(lead);
                pre_index.push_back(i);
            }
        }

        for (ll i=0;i<=m-1;i++)
        {
            if ((query[i]>pre_sum_max)&&(sum<=0))
            {
                cout << "-1 ";
            }
            else
            {
                ll min_round=0;
                if (query[i]>pre_sum_max)
                {
                    min_round=(query[i]-pre_sum_max)/sum;
                    if (((query[i]-pre_sum_max)%sum)!=0)
                    {
                        min_round++;
                    }
                }
                ll rem=query[i]-(min_round*sum);

                auto it=lower_bound(pre_inc.begin(),pre_inc.end(),rem);
                ll dval=distance(pre_inc.begin(),it);

                ll ans=n*min_round;
                if (dval==(ll)pre_index.size())
                {
                    if (ans==0)
                    {
                        ans+=*pre_index.rbegin();
                    }
                    else
                    {
                        ans+=*pre_index.rbegin()+1;
                    }
                }
                else
                {
                    ans+=pre_index[dval];
                }
                cout << ans << " ";
            }
        }
        cout << endl;
    }

    return 0;
}