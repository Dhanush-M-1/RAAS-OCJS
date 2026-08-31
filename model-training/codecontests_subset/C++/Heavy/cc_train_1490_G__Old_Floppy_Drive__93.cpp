#include <bits/stdc++.h>

#define x first
#define y second 

using namespace std;

typedef pair<int, int> PII;
typedef pair<double, double> PDD;
typedef long long LL;

const int N = 200010;

int n, m;
LL a[N];
LL s[N];
struct Stack
{
    LL s, id;
}stk[N];

int main()
{
    int t;
    cin >> t;
    while (t -- )
    {
        cin >> n >> m;
        LL maxv = 0, sum = 0;
        for (int i = 1; i <= n; i ++ ) 
        {
            cin >> a[i];
            sum += a[i];
            s[i] = s[i - 1] + a[i];
            if (i != n) maxv = max(maxv, s[i]);
        }

        int tt = 0;
        for (int i = 0; i <= n - 1; i ++ )
        {
            if (!tt || stk[tt].s < s[i]) stk[ ++ tt] = {s[i], i};
        }

        while (m -- )
        {
            LL x;
            cin >> x;

            if (maxv < x && sum <= 0)
            {
                cout << -1 << ' ';
                continue;
            }

            LL T = 0;
            if (sum > 0) T = max(T, (x - maxv + sum - 1) / sum);

            x -= T * sum;
            
        
            int l = 1, r = tt;
            while (l < r)
            {
                int mid = l + r >> 1;
                if (stk[mid].s >= x) r = mid;
                else l = mid + 1;
            }

            cout << ((LL)T * n + stk[l].id - 1) << ' ';
        }

        cout << endl;
    }
    return 0;
}