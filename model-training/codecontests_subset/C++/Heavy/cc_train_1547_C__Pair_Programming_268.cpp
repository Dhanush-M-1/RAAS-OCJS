#include <bits/stdc++.h>


using namespace std;

const int MOD = 1e9 + 7;
const int N = 1e5 + 3;
const int INF = 2e9 + 7;
const double EPS = 1e-9;


void solve() {
    int k, n, m;
    cin >> k >> n >> m;
    int a[n], b[m];
    for (int &x : a)
        cin >> x;
    for (int &x : b)
        cin >> x;
    int i = 0, j = 0;
    vector<int> res;
    while (i + j < n + m) {
        if (i < n && j < m) {
            if (a[i] == 0) {
                res.push_back(0);
                i++, k++;
            } else if (b[j] == 0) {
                res.push_back(0);
                j++, k++;
            } else {
                if (min(a[i], b[j]) > k) {
                    cout << "-1\n";
                    return;
                }
                if (a[i] < b[j]) {
                    res.push_back(a[i]);
                    i++;
                } else {
                    res.push_back(b[j]);
                    j++;
                }
            }
        } else if (i == n) {
            if (b[j] == 0) {
                res.push_back(0);
                j++, k++;
            } else {
                if (b[j] > k) {
                    cout << "-1\n";
                    return;
                }
                res.push_back(b[j]);
                j++;
            }
        } else if (j == m) {
            if (a[i] == 0) {
                res.push_back(0);
                i++, k++;
            } else {
                if (a[i] > k) {
                    cout << "-1\n";
                    return;
                }
                res.push_back(a[i]);
                i++;
            }
        }
    }
    for (int x : res)
        cout << x << ' ';
    cout << endl;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int t;
    cin >> t;
    while (t--)
        solve();
}
