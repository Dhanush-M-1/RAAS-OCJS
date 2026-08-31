#include <bits/stdc++.h>
using namespace std;
#define int long long
#define endl "\n"
#define logarr(a) for (auto i : a) cout << i << " "; cout << endl;
#define rep(i, a, n) for (int i = a; i < n; i++)
#define getarr(a) rep(i, 0, a.size()) cin >> a[i];
const int INF = 1e9+7;

struct fastIO {
    fastIO() {
        ios::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        cout << fixed << setprecision(12);
    }
} fio;

template <typename... T>
void read(T&... args) {
    ((cin >> args), ...);
}

void test_case()
{
    int k, n, m;
    read(k, n, m);
    vector<int> a(n), b(m), ans;
    getarr(a);
    getarr(b);
    int i = 0, j = 0;
    while(i < n && j < m) {
        if (a[i] == 0) {
            ans.push_back(a[i]);
            i++;
            k++;
            continue;
        }
        if (b[j] == 0) {
            ans.push_back(b[j]);
            j++;
            k++;
            continue;
        }
        if (a[i] > k && b[j] > k) {
            cout << "-1\n";
            return;
        }
        if (a[i] > k) {
            ans.push_back(b[j]);
            j++;
            continue;
        }
        if (b[j] > k) {
            ans.push_back(a[i]);
            i++;
            continue;
        }
        ans.push_back(a[i]);
        i++;
    }
    rep(ind,i,n) {
        if (a[ind] == 0) k++;
        if (a[ind] > k) {
            cout << "-1\n";
            return;
        }
        ans.push_back(a[ind]);
    }
    rep(ind,j,m) {
        if (b[ind] == 0) k++;
        if (b[ind] > k) {
            cout << "-1\n";
            return;
        }
        ans.push_back(b[ind]);
    }
    logarr(ans);
}

int32_t main()
{
    int T = 1;
    cin >> T;
    while(T--) {
        test_case();
    }

    return 0;
}
