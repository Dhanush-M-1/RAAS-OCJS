#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define mod 1000000007
void solve()
{
        int k,n,m;
        cin >> k >> n >> m;
        vector<int> a(n);
        for(auto &i:a)
        {
            cin >> i;
        }
        vector<int> b(m);
        for(auto &i:b)
        {
            cin >> i;
        }
        vector<int> res(n+m);
        int i=0,j=0,ind=0;
        while(i!=n && j!=m)
        {
            if(a[i]==0)
            {
                res[ind]=0;
                ind++;
                i++;
                k++;
            }
            else if(b[j]==0)
            {
                res[ind]=0;
                ind++;
                j++;
                k++;
            }
            else if(a[i]<=b[j] && a[i]<=k)
            {
                res[ind]=a[i];
                ind++;
                i++;
            }
            else if(a[i]>=b[j] && b[j]<=k)
            {
                res[ind]=b[j];
                ind++;
                j++;
            }
            else
            {
                cout << -1 << endl;
                return;
            }
        }
        while(i!=n)
        {
            if(a[i]==0)
            {
                res[ind]=0;
                ind++;
                i++;
                k++;
            }
            else{
            if(a[i]>k)
            {
                cout << -1 << endl;
                return;
            }
            res[ind]=a[i];
            ind++;
            i++;
            }
        }
        while(j!=m)
        {
            if(b[j]==0)
            {
                res[ind]=0;
                ind++;
                j++;
                k++;
            }
            else{
            if(b[j]>k)
            {
                cout << -1 << endl;
                return;
            }
            res[ind]=b[j];
            ind++;
            j++;}
        }
        for(auto x:res)
            cout << x << " ";
        cout << endl;
}
int main()
{
    int t;
    cin >> t;
    while(t--)
    {
        solve();
    }
}

