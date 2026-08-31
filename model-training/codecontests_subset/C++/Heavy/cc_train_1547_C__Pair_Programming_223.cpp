#include <bits/stdc++.h>
typedef long long int ll;
typedef long double ld;
using namespace std;
    
// const ll mod = 1e9 + 7;
ll n, m, k, x, y, a, b, c;

void solve()
{
    cin >> k >> n >> m;
    vector<int> a(n);
    vector<int> b(m);
    vector<int> ans;
    for (auto& i : a)
        cin >> i;
    
    for (auto& x : b)
        cin >> x;
    
    int i = 0, j = 0;
    int c = k;
    while (i != n || j != m) {
        if (i >= n) {
            if (b[j] == 0)
                ++c;
            else if (b[j] > c) {
                cout << "-1\n";
                return;
            }
            ans.push_back(b[j]);
            ++j;
        }
        else if (j >= m) {
            if (a[i] == 0)
                ++c;
            else if (a[i] > c) {
                cout << "-1\n";
                return;
            }
            ans.push_back(a[i]);
            ++i;
        }
        else {
            if (a[i] == 0) {
                ++c;
                ans.push_back(a[i]);
                ++i;
            }
            else if (b[j] == 0) {
                ++c;
                ans.push_back(b[j]);
                ++j;
            }
            else if (b[j] <= c) {
                ans.push_back(b[j]);
                ++j;
            }
            else if (a[i] <= c) {
                ans.push_back(a[i]);
                ++i;
            }
            else {
                cout << "-1\n";
                return;
            }
        }
    }
    for (auto i : ans)
        cout << i << " ";
    cout << endl;
} 

int main()
{
    auto start = chrono::high_resolution_clock::now();

    int t = 1;
    cin >> t;
    for (int i = 0; i < t; ++i) {
        solve();
    }

    #ifdef DEBUG
    auto stop = chrono::high_resolution_clock::now();
    double duration = chrono::duration_cast<chrono::nanoseconds>(stop - start).count() * 1e-9;
    cout << "execution time: " << fixed << setprecision(9) << duration << " sec" << endl;
    #endif
    return 0;
}
