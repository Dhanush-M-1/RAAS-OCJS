#include <bits/stdc++.h>
using namespace std;

const int N = 2e2 + 10;
int a[N], b[N], ans[N];

int main() {

    int t, k, n, m;
    cin >> t;
    while(t--) {
        cin.get();
        cin >> k >> n >> m;
        for(int i = 0; i < n; i++) 
            cin >> a[i];
        for(int i = 0; i < m; i++)
            cin >> b[i];

        int ida = 0, idb = 0, len = 0;
        bool flag = true;
        while(flag && (ida < n || idb < m)) {
            int ida0 = ida, idb0 = idb;
            while(ida < n) {
                if(a[ida] <= k) {
                    ans[len++] = a[ida];
                    k += (a[ida] == 0);
                    ida++; 
                } else
                    break;
            }
            while(idb < m) {
                if(b[idb] <= k) {
                    ans[len++] = b[idb];
                    k += (b[idb] == 0);
                    idb++;
                } else
                    break;
            }
            if(!(ida - ida0 || idb - idb0))
                flag = false;
        }

        if(!flag) {
            cout << -1 << endl;
            continue;
        }
        for(int i = 0; i < len; i++) 
            i == len - 1 ? printf("%d\n", ans[i]) : printf("%d ", ans[i]);
    }

    return 0;
}