#include<iostream>
#include<string>
#include<algorithm>
#include<vector>
#include<map>
#include<cstring>
using namespace std;

#define rep(i,n) for(int i=0;i<n;i++)
#define REP(n) rep(i,n)
#define all(n) n.begin(),n.end()

const int MAXN = 101;

int a[MAXN];

int main()
{
    int n;
    while(cin >> n && n)
    {
        REP(n) cin >> a[i];
        int ans = 0;

        for(int j = n - 1; j > 0;j--)REP(j)
        {
            if(a[i] > a[i+1]){ swap(a[i], a[i+1]);ans++; }

        }
        cout << ans << endl;
    }

    return 0;
}