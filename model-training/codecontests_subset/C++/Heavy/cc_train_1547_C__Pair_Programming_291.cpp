#include<bits/stdc++.h>
using namespace std;
long long t, k, n, m, a[100], b[100], i, j, br, p;
vector<long long> ans;
bool fl1, fl2;
char c;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin>>t;
    cin.get(c);
    while(t --)
    {
        cin.get(c);
        cin>>k>>n>>m;
        for(i = 0; i < n; i ++) cin>>a[i];
        for(i = 0; i < m; i ++) cin>>b[i];
        i = j = 0;
        fl1 = fl2 = 1;
        br = p = 0;
        while(br != n + m && fl1 && fl2)
        {
            fl1 = fl2 = 0;           // cout<<br<<" "<<i<<" "<<j<<endl;
            while(a[i] <= k && i < n)
            {
                ans.push_back(a[i]);
                if(!a[i]) k ++;
                i ++;
                br ++;
                fl1 = 1;
            }
            if(!p) fl1 = 1;
            while(b[j] <= k && j < m)
            {
                ans.push_back(b[j]);
                if(!b[j]) k ++;
                j ++;
                br ++;
                fl2 = 1;
            }
            p ++;
        }
        if(br == n + m)
        {
            for(i = 0; i < ans.size(); i ++) cout<<ans[i]<<' ';
            cout<<'\n';
        }
        else cout<<-1<<'\n';
        ans.clear();
    }
    return 0;
}
/*
5

3 2 2
2 0
0 5

4 3 2
2 0 5
0 6

0 2 2
1 0
2 3

5 4 4
6 0 8 0
0 7 0 9

5 4 1
8 7 8 0
0

*/


