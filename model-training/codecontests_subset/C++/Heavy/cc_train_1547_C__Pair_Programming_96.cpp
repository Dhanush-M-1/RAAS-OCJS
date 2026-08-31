#include <bits/stdc++.h>
#define ll long long
#define ld long double
#define endl '\n'
int dx[] = { 0, -1, 0, 1, -1, 1, -1, 1 };
int dy[] = { -1, 0, 1, 0, 1, -1, -1, 1 };
const int N = 2e5+ 5, mod = 1e9 + 7;
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int t; cin>>t;
    while(t--)
    {
        int k, n, m; cin>>k>>n>>m;
        int arr[n + 5], brr[m + 5];
        for(int i = 0; i < n; i++) cin>>arr[i];
        for(int i = 0; i < m; i++) cin>>brr[i];
        int i = 0, j = 0;
        vector<int> vec;
        while(i < n || j < m)
        {
            bool change = false;
            if(i < n)
            {
                if(!arr[i]) i++, k++, change = true, vec.push_back(arr[i - 1]);
                else if(arr[i] <= k) i++, change = true, vec.push_back(arr[i - 1]);
            }
            if(j < m && !change)
            {
                if(!brr[j]) j++, k++, change = true, vec.push_back(brr[j - 1]);
                else if(brr[j] <= k) j++, change = true, vec.push_back(brr[j - 1]);
            }
            if(!change)
            {
                cout<<-1<<endl;
                goto done;
            }
        }
        for(auto it : vec) cout<<it<<' ';
        cout<<endl;
        done:;
    }
    return 0;
}